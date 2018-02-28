package com.flyread.file.export.excel;

import com.flyread.file.export.base.BaseExportContext;
import com.flyread.file.export.base.ExportHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author by hongbf on 2018/2/26.
 */
public class ExcelHeaderFilterHandler implements ExportHandler {
    private List<String> filterHeaders;

    public ExcelHeaderFilterHandler(List<String> filterHeaders) {
        this.filterHeaders = filterHeaders;
    }

    @Override
    public void handleRequest(BaseExportContext context) throws Exception {
        ExcelExportContext c = (ExcelExportContext) context;
        ExcelExportData meta = (ExcelExportData) c.getRequest().getExportData();
        meta.setHeaders(meta.getHeaders().stream().filter(h -> !filterHeaders.contains(h)).collect(Collectors.toList()));
    }
}
