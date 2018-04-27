package com.flyread.file.export.base;

import com.flyread.file.export.base.impl.DefaultExportPipeline;
import com.flyread.file.export.excel.ExcelExportServiceImpl;
import com.flyread.file.export.excel.ExcelWriteHandler;
import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.txt.TxtDecodeHandler;
import com.flyread.file.export.txt.TxtExportServiceImpl;
import com.flyread.file.export.txt.TxtWriteHandler;

/**
 * @author by hongbf on 2018/2/26.
 */
public class ExportFactory {
    public static ExportService create(ExportType type, ExportRequest request) {
        switch (type) {
            case EXCEL:
                return new ExcelExportServiceImpl(new DefaultExportPipeline(request).addFirst(new ExcelWriteHandler()));
            case TXT:
                return new TxtExportServiceImpl(new DefaultExportPipeline(request).addFirst(new TxtWriteHandler()).addFirst(new TxtDecodeHandler()));
            default:
                throw new RuntimeException("type is invalid!");
        }
    }
}
