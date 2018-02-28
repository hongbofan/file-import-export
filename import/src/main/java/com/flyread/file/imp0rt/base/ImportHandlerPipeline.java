package com.flyread.file.imp0rt.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ImportHandlerPipeline implements ImportHandler {
    private List<ImportHandler> handlers = new ArrayList<>();
    public ImportHandlerPipeline addLast(ImportHandler handler) {
        handlers.add(handler);
        return this;
    }
    @Override
    public void handleRequest(BaseImportContext context) throws Exception{
        for (ImportHandler h : handlers) {
            h.handleRequest(context);
        }
    }
}
