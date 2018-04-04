package com.flyread.file.imp0rt.excel;

import com.flyread.file.imp0rt.base.impl.BaseImportHandlerContext;
import com.flyread.file.imp0rt.base.impl.BaseReadHandler;
import com.flyread.file.imp0rt.model.ImportRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

import static com.flyread.file.imp0rt.util.ImportUtil.getCellValue;

/**
 * @author by hongbf on 2018/3/21.
 */
public class ExcelReadLineHandler extends BaseReadHandler {

    @Override
    protected void readLine(BaseImportHandlerContext context, List<Object> list, Object msg) {
        if (msg instanceof Row) {
            Row row0 = (Row) msg;
            Cell cell;
            StringBuilder sb = new StringBuilder();
            for (int j = row0.getFirstCellNum(); j <= row0.getLastCellNum(); j++) {
                cell = row0.getCell(j);
                if (cell == null) {
                    continue;
                }
                sb.append(getCellValue(cell).toString()).append(" ");
            }
            ImportRow row1 = new ImportRow(sb.toString());
            list.add(row1);
        }
    }
}
