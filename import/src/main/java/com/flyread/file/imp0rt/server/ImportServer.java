package com.flyread.file.imp0rt.server;

import com.flyread.file.imp0rt.base.BaseImportContext;
import com.flyread.file.imp0rt.base.ImportHandlerPipeline;
import com.flyread.file.imp0rt.excel.*;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;

import java.io.File;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 2018/2/11.
 */
public class ImportServer {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\DELL\\Desktop\\新建文件夹\\template.xls");
        ImportRequest request = new ImportRequest(file);
        BaseImportContext context = new ExcelImportContext();
        context.setRequest(request);
        context.setResponse(new ImportResponse());
        Map<ExcelCellType,Format> map = new HashMap<>();
        map.put(ExcelCellType.CELL_TYPE_NUMERIC, DecimalFormat.getPercentInstance());
        System.out.println(new ExcelImportServiceImpl(context,new ImportHandlerPipeline().addLast(new DefaultExcelImportHandler(new ExcelImportTranslate(map)))).imp0rt().getImportCount());
    }

}
