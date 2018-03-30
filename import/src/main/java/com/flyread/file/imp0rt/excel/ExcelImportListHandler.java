/*
package com.flyread.file.imp0rt.excel;

import com.flyread.file.imp0rt.base.BaseImportContext;
import com.flyread.file.imp0rt.base.BaseImportHandlerContext;
import com.flyread.file.imp0rt.base.ImportHandler;
import com.flyread.file.imp0rt.model.ImportRequest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

*/
/**
 * @author by hongbf on 2018/3/1.
 *//*

public class ExcelImportListHandler implements ImportHandler {
    @Override
    public void handleRequest(BaseImportHandlerContext context1,BaseImportContext context) throws Exception {
        ImportRequest request = context.getRequest();
        File file = request.getImportFile();
        int selectSheet = request.getSelectSheet();
        Workbook workbook = null;
        try{
            workbook = WorkbookFactory.create(file);
        }catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(workbook);
        }


        List<Sheet> sheets = new ArrayList<>();
        if (selectSheet < 0) {
            int sheetsCount = workbook.getNumberOfSheets();
            for (int i = 0; i < sheetsCount;i++) {
                sheets.add(workbook.getSheetAt(i));
            }
        } else {
            sheets.add(workbook.getSheetAt(selectSheet));
        }
        int totalRow = 0;
        for (Sheet sheet : sheets) {
            if (sheet.getPhysicalNumberOfRows() > 0) {
                totalRow += sheet.getLastRowNum() + 1;
            }
        }
        final int totalRowNum = totalRow;

        AtomicInteger currentNum = new AtomicInteger(request.getStartRowNum() > 1 ? request.getStartRowNum() : 1);

        Iterator<Row> iterator = new Iterator<Row>() {
            @Override
            public boolean hasNext() {
                return currentNum.get() <= totalRowNum;
            }

            @Override
            public Row next() {
                int sheetRowCount = 0;
                Row currentRow = null;
                int currentRowNum = currentNum.get();
                int retryCount = 0;
                for (int i = 0; i < sheets.size();i++) {
                    Sheet sheet = sheets.get(i);
                    if (currentRowNum <= sheetRowCount + sheet.getLastRowNum() + 1) {
                        currentRow = sheet.getRow(currentRowNum - sheetRowCount - 1);
                        if (currentNum.compareAndSet(currentRowNum,currentRowNum + 1)) {
                            break;
                        } else if (retryCount < 5) {
                            i--;
                            retryCount++;
                            continue;
                        }
                    }
                    sheetRowCount += sheet.getLastRowNum() + 1;
                }
                return currentRow;
            }
        };
        context.setIterator(iterator);
    }
}
*/
