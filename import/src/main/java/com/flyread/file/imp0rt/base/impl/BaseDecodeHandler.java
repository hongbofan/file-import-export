package com.flyread.file.imp0rt.base.impl;


import com.flyread.file.imp0rt.base.ImportHandler;
import com.flyread.file.imp0rt.model.ImportConfig;
import com.flyread.file.imp0rt.model.ImportRecord;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author by hongbf on 2018/3/16.
 */
public abstract class BaseDecodeHandler implements ImportHandler {
    private Map<String, String> headerMap;
    @Override
    public void handleRequest(BaseImportHandlerContext context, Object msg) throws Exception {
        if (msg instanceof ImportRow) {
            ImportRow row = (ImportRow) msg;
            ImportConfig config = context.pipeline().getRequest().getConfig();

            String[] splits = row.getData().split(config.getSeparator());
            if (headerMap == null) {
                headerMap = config.getHeaderMap();
            }
            context.fireChannelRead(decode(splits, headerMap));

        }
    }

    protected ImportRecord decode(String[] splits, Map<String, String> headerMap) {
        ImportRecord record = new ImportRecord();
        List<String> list = new ArrayList<>();
        for (String s : splits) {
            if (headerMap.containsKey(s)) {
                record.setHeader(true);
                list.add(headerMap.get(s));
            } else {
                list.add(s);
            }
        }
        record.setList(list);
        return record;
    }
}
