package com.flyread.file.imp0rt.base.impl;

import com.flyread.file.imp0rt.model.BaseImportRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by hongbf on 2018/5/2.
 */
public class HeaderMappingHandler extends BaseRowToRowHandler<BaseImportRow> {

    public HeaderMappingHandler() {
        super(BaseImportRow.class);
    }

    @Override
    protected void process(BaseImportHandlerContext context, BaseImportRow row,List<Object> out) throws Exception{
        Map<String, String> headerMap = context.pipeline().getRequest().getConfig().getHeaderMap();
        if (headerMap != null && headerMap.size() > 0) {

            Map<String, Object> map = row.getMap();
            Map<String,Object> newMap = new HashMap<>(map.size());
            row.setMap(newMap);
            map.forEach((k,v) -> {
                String key = k;
                if (headerMap.containsKey(k)) {
                    k = headerMap.get(k);
                }
                newMap.put(key,v);
            });
            out.add(row);
        }
    }
}
