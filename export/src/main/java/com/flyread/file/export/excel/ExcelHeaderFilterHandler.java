package com.flyread.file.export.excel;

import com.flyread.file.export.base.ExportHandler;
import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

import java.io.OutputStream;
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
    public void handleRequest(ExportRequest request, ExportResponse response, OutputStream out) throws Exception {
        ExcelData meta = (ExcelData) request.getExportData();
        meta.setHeaders(meta.getHeaders().stream().filter(h -> !filterHeaders.contains(h)).collect(Collectors.toList()));
    }
}
