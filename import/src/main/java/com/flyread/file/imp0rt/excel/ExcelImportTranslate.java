package com.flyread.file.imp0rt.excel;

import com.flyread.file.imp0rt.base.ImportTranslate;
import org.apache.poi.ss.usermodel.Cell;

import java.text.Format;
import java.util.Map;

import static com.flyread.file.imp0rt.util.ImportUtil.getCellValue;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ExcelImportTranslate implements ImportTranslate {

    private Map<ExcelCellType,Format> formatMap;

    public ExcelImportTranslate(Map<ExcelCellType, Format> formatMap) {
        this.formatMap = formatMap;
    }

    @Override
    public Object translate(Object o) {
        Cell cell = (Cell) o;
        Object value = getCellValue(cell);
        for (Map.Entry entry : formatMap.entrySet()) {
            ExcelCellType k = (ExcelCellType) entry.getKey();
            Format v = (Format) entry.getValue();
            if (k.getCode().equals(cell.getCellType() + "")) {
                value = v.format(value);
            }
        }
        return value;
    }
}
