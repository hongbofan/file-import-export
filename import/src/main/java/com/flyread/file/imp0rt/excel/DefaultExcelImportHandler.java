package com.flyread.file.imp0rt.excel;

import com.flyread.file.imp0rt.base.BaseImportContext;
import com.flyread.file.imp0rt.base.ImportHandler;
import com.flyread.file.imp0rt.model.ImportRecord;
import com.flyread.file.imp0rt.model.ImportResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import static com.flyread.file.imp0rt.util.ImportUtil.getCellValue;

/**
 * @author by hongbf on 2018/2/28.
 */
public class DefaultExcelImportHandler implements ImportHandler {

    private ExcelImportTranslate translate;

    public DefaultExcelImportHandler(ExcelImportTranslate translate) {
        this.translate = translate;
    }

    @Override
    public void handleRequest(BaseImportContext context) throws Exception {
        ImportResponse response = context.getResponse();
        File file = context.getRequest().getImportFile();
        List<List<Object>> list = new LinkedList<>();
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
            int sheetsNumber = workbook.getNumberOfSheets();
            for (int n = 0; n < sheetsNumber; n++) {
                Sheet sheet = workbook.getSheetAt(n);
                Object value;
                Row row;
                Cell cell;
                for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) { // 从第二行开始读取
                    row = sheet.getRow(i);
                    if (row == null) {
                        continue;
                    }
                    List<Object> linked = new LinkedList<>();
                    for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                        cell = row.getCell(j);
                        if (cell == null) {
                            continue;
                        }
                        value = translate.translate(cell);
                        linked.add(value);
                    }
                    ImportRecord record = new ImportRecord();
                    record.setList(linked);
                    System.out.println(record);
                    list.add(linked);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(workbook);
        }
        System.out.println(" linked.size " + list.size());
        response.setImportCount(list.size());
    }
}
