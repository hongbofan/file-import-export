package com.flyread.file.imp0rt.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * Created by DELL on 2018/2/25.
 */
public class ImportUtil {
    private static final DecimalFormat df = new DecimalFormat("0");// 格式化 number为整

    private static final DecimalFormat df_per = new DecimalFormat("##.00%");//格式化分比格式，后面不足2位的用0补齐

    //private static final DecimalFormat df_per_ = new DecimalFormat("0.00%");//格式化分比格式，后面不足2位的用0补齐,比如0.00,%0.01%

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串

    private static final DecimalFormat sc_number  = new DecimalFormat("0.00E000"); //格式化科学计数器

    private static final Pattern points_ptrn = Pattern.compile("0.0+_*[^/s]+");

    public static Object getCellValue(Cell cell) {
        Object value;
        switch (cell.getCellType()) {
            case 0:
                value = cell.getNumericCellValue();
                break;
            case 1:
                value = cell.getStringCellValue();
                break;
            case 2:
                value = cell.getCellFormula();
                break;
            case 3:
                value = cell.getStringCellValue();
                break;
            case 4:
                value = cell.getBooleanCellValue();
                break;
            default:
                value = cell.getErrorCellValue();
        }
        return value;
    }
}
