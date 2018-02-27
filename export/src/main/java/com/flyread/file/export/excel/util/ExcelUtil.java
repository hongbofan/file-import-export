package com.flyread.file.export.excel.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by hongbf on 2018/2/26.
 */
public class ExcelUtil {
    public static HSSFCell getCellByCoordinate(HSSFWorkbook workbook, int sheetNum, int row, int col) {
        return workbook.getSheetAt(sheetNum).getRow(row).getCell(col);
    }

    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }
}
