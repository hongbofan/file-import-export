package com.flyread.file.imp0rt.base.impl;


import com.flyread.file.imp0rt.model.BaseImportRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by hongbf on 2018/3/16.
 */
public class RowHeaderHandler extends BaseRowToRowHandler<BaseImportRow> {
    private Object[] headers;
    private boolean hasHeader;
    private boolean skipBlankRow;

    public RowHeaderHandler() {
        super(BaseImportRow.class);
    }

    public RowHeaderHandler(boolean hasHeader,boolean skipBlankRow) {
        super(BaseImportRow.class);
        this.hasHeader = hasHeader;
        this.skipBlankRow = skipBlankRow;
    }

    @Override
    protected void process(BaseImportHandlerContext context, BaseImportRow row, List<Object> out) throws Exception {
        if (skipBlankRow && isBlankRow(row)) {
            return;
        }
        if (hasHeader && headers == null) {
            headers = row.asArray();
            return;
        }
        int length = headers == null ? row.size() : headers.length;
        Map<String, Object> map = row.getMap();
        if (map == null) {
            map = new HashMap<>(length);
            row.setMap(map);
        }
        for (int i = 0; i < length; i++) {
            map.put(hasHeader ? headers[i].toString() : Integer.toString(i + 1), row.get(i));
        }
        out.add(row);
    }

    private boolean isBlankRow(BaseImportRow row) {
        return row == null || row.size() == 0;
    }
}
