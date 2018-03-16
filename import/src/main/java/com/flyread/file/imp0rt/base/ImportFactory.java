package com.flyread.file.imp0rt.base;

import com.flyread.file.imp0rt.excel.ExcelImportContext;
import com.flyread.file.imp0rt.excel.ExcelImportServiceImpl;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;

/**
 * @author by hongbf on 2018/3/14.
 */
public class ImportFactory {
    public static ImportService create(ImportType type, ImportHandlerPipeline pipeline, ImportRequest request) {
        switch (type) {
            case EXCEL:
                ExcelImportContext context = new ExcelImportContext();
                context.setRequest(request);
                context.setPipeline(pipeline);
                context.setResponse(new ImportResponse());
                return new ExcelImportServiceImpl(context);
            default: return null;
        }
    }
}
