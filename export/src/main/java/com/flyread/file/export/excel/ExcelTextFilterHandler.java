package com.flyread.file.export.excel;

import com.flyread.file.export.base.BaseExportContext;
import com.flyread.file.export.base.ExportHandler;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ExcelTextFilterHandler implements ExportHandler {
    @Override
    public void handleRequest(BaseExportContext context) throws Exception {
        ExcelExportContext c = (ExcelExportContext) context;
        ExcelExportData data = (ExcelExportData) c.getRequest().getExportData();
        data.getMap().forEach((k,v) -> {

        });
    }
}
