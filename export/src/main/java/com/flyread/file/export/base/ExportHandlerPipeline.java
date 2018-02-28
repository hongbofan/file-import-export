package com.flyread.file.export.base;

import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by hongbf on 2018/2/26.
 */
public class ExportHandlerPipeline implements ExportHandler {
    private List<ExportHandler> handlers = new ArrayList<>();
    public ExportHandlerPipeline addLast(ExportHandler handler) {
        handlers.add(handler);
        return this;
    }
    @Override
    public void handleRequest(BaseExportContext context) throws Exception{
        for (ExportHandler h : handlers) {
            h.handleRequest(context);
        }
    }
}
