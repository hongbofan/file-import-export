package com.flyread.file.export.base;

import com.flyread.file.export.excel.ExcelExportServiceImpl;

import java.io.File;

import static com.flyread.file.export.base.ExportType.EXCEL;

/**
 * @author by hongbf on 2018/2/26.
 */
public class ExportFactory {
    public static ExportService create(ExportType type,ExportHandlerPipeline pipeline, File file,String prefix) {
        switch (type) {
            case EXCEL: return new ExcelExportServiceImpl(pipeline,file,prefix);
            default: return new ExcelExportServiceImpl(pipeline,file,prefix);
        }
    }
}
