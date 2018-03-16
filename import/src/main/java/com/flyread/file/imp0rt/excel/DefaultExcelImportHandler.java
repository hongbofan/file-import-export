package com.flyread.file.imp0rt.excel;

import com.flyread.file.imp0rt.base.BaseImportContext;
import com.flyread.file.imp0rt.base.ImportHandler;
import com.flyread.file.imp0rt.base.ImportTranslate;
import com.flyread.file.imp0rt.model.ImportRecord;
import com.flyread.file.imp0rt.model.ImportResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static com.flyread.file.imp0rt.util.ImportUtil.getCellValue;

/**
 * @author by hongbf on 2018/2/28.
 */
public class DefaultExcelImportHandler implements ImportHandler {

    @Override
    public void handleRequest(BaseImportContext context) throws Exception {
        ImportResponse response = context.getResponse();
        ImportTranslate translate = context.getRequest().getTranslate();
        Iterator iterator = context.getIterator();
        List<List<Object>> list = new LinkedList<>();
        while (iterator.hasNext()) {
            Row row = (Row) iterator.next();
            Cell cell;
            Object value;
            List<Object> linked = new LinkedList<>();
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }
                if (translate != null) {
                    value = translate.translate(cell);
                } else {
                    value = getCellValue(cell);
                }

                linked.add(value);
            }
/*            ImportRecord record = new ImportRecord();
            record.setList(linked);*/
            list.add(linked);
        }
        response.setImportCount(list.size());
        response.setData(list);
    }
}
