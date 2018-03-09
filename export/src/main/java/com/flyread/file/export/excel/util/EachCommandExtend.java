package com.flyread.file.export.excel.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.jxls.area.Area;
import org.jxls.command.AbstractCommand;
import org.jxls.command.CellRefGenerator;
import org.jxls.command.Command;
import org.jxls.command.SheetNameGenerator;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.common.JxlsException;
import org.jxls.common.Size;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.util.Util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;


/**
 * @author by hongbf on 2018/2/27.
 */
public class EachCommandExtend extends AbstractCommand {
    public enum Direction {RIGHT, DOWN}

    private String var;
    private String items;
    private String select;
    private Area area;
    private Direction direction = Direction.DOWN;
    private CellRefGenerator cellRefGenerator;
    private String multisheet;
    private Map<String,String[]> filterHeader;

    public EachCommandExtend() {
    }

    /**
     * @param var       name of the key in the context to contain each collection items during iteration
     * @param items     name of the collection bean in the context
     * @param direction defines processing by rows (DOWN - default) or columns (RIGHT)
     */
    public EachCommandExtend(String var, String items, Direction direction) {
        this.var = var;
        this.items = items;
        this.direction = direction == null ? Direction.DOWN : direction;
    }

    public EachCommandExtend(String var, String items, Area area) {
        this(var, items, area, Direction.DOWN);
    }

    public EachCommandExtend(String var, String items, Area area, Direction direction) {
        this(var, items, direction);
        if (area != null) {
            this.area = area;
            addArea(this.area);
        }
    }

    /**
     * @param var              name of the key in the context to contain each collection items during iteration
     * @param items            name of the collection bean in the context
     * @param area             body area for this command
     * @param cellRefGenerator generates target cell ref for each collection item during iteration
     */
    public EachCommandExtend(String var, String items, Area area, CellRefGenerator cellRefGenerator) {
        this(var, items, area, (Direction) null);
        this.cellRefGenerator = cellRefGenerator;
    }

    /**
     * Gets iteration directino
     *
     * @return current direction for iteration
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Sets iteration direction
     *
     * @param direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setDirection(String direction) {
        this.direction = Direction.valueOf(direction);
    }

    /**
     * Gets defined cell ref generator
     *
     * @return current {@link CellRefGenerator} instance or null
     */
    public CellRefGenerator getCellRefGenerator() {
        return cellRefGenerator;
    }

    public void setCellRefGenerator(CellRefGenerator cellRefGenerator) {
        this.cellRefGenerator = cellRefGenerator;
    }

    @Override
    public String getName() {
        return "each";
    }

    /**
     * Gets current variable name for collection item in the context during iteration
     *
     * @return collection item key name in the context
     */
    public String getVar() {
        return var;
    }

    /**
     * Sets current variable name for collection item in the context during iteration
     *
     * @param var
     */
    public void setVar(String var) {
        this.var = var;
    }

    /**
     * Gets collection bean name
     *
     * @return collection bean name in the context
     */
    public String getItems() {
        return items;
    }

    /**
     * Sets collection bean name
     *
     * @param items collection bean name in the context
     */
    public void setItems(String items) {
        this.items = items;
    }

    /**
     * Gets current 'select' expression for filtering out collection items
     *
     * @return current 'select' expression or null if undefined
     */
    public String getSelect() {
        return select;
    }

    /**
     * Sets current 'select' expression for filtering collection
     *
     * @param select filtering expression
     */
    public void setSelect(String select) {
        this.select = select;
    }

    /**
     * @return Context variable name holding a list of Excel sheet names to output the collection to
     */
    public String getMultisheet() {
        return multisheet;
    }

    /**
     * Sets name of context variable holding a list of Excel sheet names to output the collection to
     * @param multisheet
     */
    public void setMultisheet(String multisheet) {
        this.multisheet = multisheet;
    }

    @Override
    public Command addArea(Area area) {
        if (area == null) {
            return this;
        }
        if (super.getAreaList().size() >= 1) {
            throw new IllegalArgumentException("You can add only a single area to 'each' command");
        }
        this.area = area;
        return super.addArea(area);
    }

    @Override
    public Size applyAt(CellRef cellRef, Context context) {
        System.out.println("eachExtend");
        Gson gson = new Gson();
        Collection itemsCollection = Util.transformToCollectionObject(getTransformationConfig().getExpressionEvaluator(), items, context);
        int width = 0;
        int height = 0;
        int index = 0;
        CellRefGenerator cellRefGenerator = this.cellRefGenerator;
        if (cellRefGenerator == null && multisheet != null) {
            List<String> sheetNameList = extractSheetNameList(context);
            cellRefGenerator = new SheetNameGenerator(sheetNameList, cellRef);
        }
        CellRef currentCell = cellRefGenerator != null ? cellRefGenerator.generateCellRef(index, context) : cellRef;
        JexlExpressionEvaluator selectEvaluator = null;
        if (select != null) {
            selectEvaluator = new JexlExpressionEvaluator(select);
        }
        for (Object obj : itemsCollection) {
            if (filterHeader != null && filterHeader.size() > 0) {
                Class<?> cls = obj.getClass();
                filterHeader.forEach((k,v) -> {
                    try {
                        Field f = cls.getDeclaredField(k);
                        f.setAccessible(true);
                        Object val = f.get(obj);
                        String s = String.valueOf(val);
                        f.set(obj,s.replaceAll(v[1],v[2]));
                    } catch (Exception e) {
                        throw new JxlsException("reflect error!" , e);
                    }
                });

            }

            context.putVar(var, obj);
            context.putVar(var+"_index", index);
            if (selectEvaluator != null && !Util.isConditionTrue(selectEvaluator, context)) {
                context.removeVar(var);
                context.removeVar(var+"_index");
                continue;
            }
            Size size = area.applyAt(currentCell, context);
            index++;
            if (cellRefGenerator != null) {
                width = Math.max(width, size.getWidth());
                height = Math.max(height, size.getHeight());
                if(index < itemsCollection.size()) {
                    currentCell = cellRefGenerator.generateCellRef(index, context);
                }
            } else if (direction == Direction.DOWN) {
                currentCell = new CellRef(currentCell.getSheetName(), currentCell.getRow() + size.getHeight(), currentCell.getCol());
                width = Math.max(width, size.getWidth());
                height += size.getHeight();
            } else {
                currentCell = new CellRef(currentCell.getSheetName(), currentCell.getRow(), currentCell.getCol() + size.getWidth());
                width += size.getWidth();
                height = Math.max(height, size.getHeight());
            }
            context.removeVar(var);
            context.removeVar(var+"_index");
        }
        return new Size(width, height);
    }

    private List<String> extractSheetNameList(Context context) {
        try {
            return (List<String>) context.getVar(multisheet);
        } catch (Exception e) {
            throw new JxlsException("Failed to get sheet names from " + multisheet, e);
        }
    }

    public Map<String, String[]> getFilterHeader() {
        return filterHeader;
    }

    public void setFilterHeader(String filterHeader) {
        String[] filters = filterHeader.split(",");
        this.filterHeader = new HashMap<>(filters.length);
        for (String filter : filters) {
            String[] ss = filter.split("::");
            if (ss.length != 3) {
                throw new JxlsException("filter must be #{header}::#{pattern}::#{replaceValue}");
            }
            this.filterHeader.put(ss[0],ss);
        }
    }
}
