package com.flyread.file.export.base;

import com.flyread.file.export.excel.ExcelExportContext;
import com.flyread.file.export.excel.ExcelExportServiceImpl;
import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

/**
 * @author by hongbf on 2018/2/26.
 */
public class ExportFactory {
    public static ExportService create(ExportType type,ExportHandlerPipeline pipeline, ExportRequest request) {
        switch (type) {
            case EXCEL:
                ExcelExportContext context = new ExcelExportContext();
                context.setRequest(request);
                context.setResponse(new ExportResponse());
                context.setPipeline(pipeline);
                return new ExcelExportServiceImpl(context);
            default: return null;
        }
    }
}
