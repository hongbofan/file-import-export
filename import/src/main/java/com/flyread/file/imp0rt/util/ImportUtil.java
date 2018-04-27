package com.flyread.file.imp0rt.util;

import com.flyread.file.imp0rt.excel.ExcelCellType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import static com.flyread.file.imp0rt.excel.ExcelCellType.CELL_TYPE_NUMERIC;

/**
 * @author  by hongbf on 2018/2/25.
 */
public class ImportUtil {
    public final static String DEFAULT_CHARSET_NAME = "UTF-8";
    public static Object getCellValue(Cell cell) {
        Object value;
        ExcelCellType type = ExcelCellType.getStatusByCode(cell.getCellType());
        if (type == null) {
            throw new RuntimeException("cell type is invalid:" + cell.getCellType());
        }
        switch (type) {
            case CELL_TYPE_NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case CELL_TYPE_FORMULA:
                value = cell.getCellFormula();
                break;
            case CELL_TYPE_BLANK:
                value = cell.getStringCellValue();
                break;
            case CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case CELL_TYPE_ERROR:
                value = cell.getErrorCellValue();
                break;
            default:
                value = "";
        }
        return value;
    }
}
