package com.flyread.file.imp0rt.model;

import com.flyread.file.imp0rt.util.ImportUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author by hongbf on 2018/5/2.
 */
public class ExcelRow extends BaseImportRow {

    private org.apache.poi.ss.usermodel.Row row;

    public ExcelRow(Row row) {
        this.row = row;
    }

    @Override
    public Object get(int idx) {
        return ImportUtil.getCellValue(row.getCell(idx + 1));
    }

    @Override
    public Object[] asArray() {
        List<Object> list = new ArrayList<>();
        row.forEach(c -> list.add(ImportUtil.getCellValue(c)));
        return list.toArray();
    }

    @Override
    public int size() {
        return row == null ? 0 : row.getPhysicalNumberOfCells();
    }
}
