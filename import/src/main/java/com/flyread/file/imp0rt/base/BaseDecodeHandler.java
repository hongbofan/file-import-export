package com.flyread.file.imp0rt.base;


import com.flyread.file.imp0rt.model.ImportRecord;
import com.flyread.file.imp0rt.model.ImportRow;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by hongbf on 2018/3/16.
 */
public abstract class BaseDecodeHandler implements ImportHandler {
    private String json;
    private List<ImportRow> waitingRows = new ArrayList<>();
    @Override
    public void handleRequest(BaseImportHandlerContext context, Object msg) throws Exception {
        if (msg instanceof ImportRow) {
            ImportRow row = (ImportRow) msg;
            context.fireChannelRead(decode(context, row));
        }
    }

    protected abstract ImportRecord decode(BaseImportHandlerContext context, ImportRow row);
}
