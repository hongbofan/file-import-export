package com.flyread.file.imp0rt.excel;

import com.flyread.file.imp0rt.model.ImportRecord;
import com.flyread.file.imp0rt.util.ImportUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by hongbf on 2018/2/25.
 */
public class ExcelIterator implements Iterator<ImportRecord> {
    private Workbook workbook;
    private int sheetsNumber;
    private int currentSheet;
    private Sheet sheet;
    private int rowIndex;

    public ExcelIterator(File file) {
        try {
            this.workbook = WorkbookFactory.create(file);
            this.sheetsNumber = workbook.getNumberOfSheets();
            this.currentSheet = 0;
            sheet = workbook.getSheetAt(currentSheet);
            rowIndex = sheet.getFirstRowNum() + 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(workbook);
        }

    }

    @Override
    public boolean hasNext() {
        return currentSheet < sheetsNumber && rowIndex < sheet.getPhysicalNumberOfRows();
    }

    @Override
    public ImportRecord next() {
        Row row = sheet.getRow(rowIndex);
        List<Object> linked = new LinkedList<>();
        ImportRecord record = new ImportRecord();
        record.setList(linked);
        if (row == null) {
            return record;
        }
        for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
            Cell cell = row.getCell(j);
            if (cell == null) {
                continue;
            }
            Object value = ImportUtil.getCellValue(cell);
            linked.add(value);
        }
        rowIndex++;
        if (rowIndex >= sheet.getPhysicalNumberOfRows() && currentSheet < sheetsNumber) {
            currentSheet++;
            if (currentSheet < sheetsNumber) {
                sheet = workbook.getSheetAt(currentSheet);
                rowIndex = 0;
            }
        }
        return record;
    }
}
