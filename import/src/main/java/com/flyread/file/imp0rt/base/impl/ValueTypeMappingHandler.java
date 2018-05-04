package com.flyread.file.imp0rt.base.impl;

import com.flyread.file.imp0rt.model.BaseImportRow;

import java.util.List;

/**
 * @author by hongbf on 2018/5/3.
 */
public class ValueTypeMappingHandler extends BaseRowToRowHandler<BaseImportRow> {
    protected ValueTypeMappingHandler() {
        super(BaseImportRow.class);
    }

    @Override
    protected void process(BaseImportHandlerContext context, BaseImportRow row, List<Object> out) throws Exception {

    }
}
