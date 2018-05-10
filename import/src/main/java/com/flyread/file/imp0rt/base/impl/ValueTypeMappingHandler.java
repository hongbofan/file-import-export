package com.flyread.file.imp0rt.base.impl;

import com.flyread.file.imp0rt.model.BaseImportRow;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by hongbf on 2018/5/3.
 */
public class ValueTypeMappingHandler extends BaseRowToRowHandler<BaseImportRow> {
    private Map<String,String> valueTypeMap;
    public ValueTypeMappingHandler() {
        super(BaseImportRow.class);
    }

    public ValueTypeMappingHandler(Map<String, String> valueTypeMap) {
        super(BaseImportRow.class);
        this.valueTypeMap = valueTypeMap;
    }

    @Override
    protected void process(BaseImportHandlerContext context, BaseImportRow row, List<Object> out) throws Exception {
        if (valueTypeMap != null && valueTypeMap.size() > 0) {
            valueTypeMap.forEach((k,v) ->  {
                Object o = row.get(k);
                if (o != null) {
                    row.set(k,castType(o,v));
                }
            });
            out.add(row);
        }
    }

    protected Object castType(Object o,String type) {
        if ("String".equalsIgnoreCase(type)) {
            return o.toString();
        }
        if ("Date".equals(type)) {
            if (o instanceof String) {
                return LocalDate.parse((CharSequence) o);
            }
        }
        if ("DateTime".equals(type)) {
            if (o instanceof String) {
                return LocalDateTime.parse((CharSequence) o);
            }
        }
        if ("Integer".equals(type)) {
            if (o instanceof Double) {
                return ((Double) o).intValue();
            }
        }
        return o;
    }
}
