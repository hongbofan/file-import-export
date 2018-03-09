package com.flyread.file.export.excel;


import java.util.HashMap;
import java.util.Map;


/**
 * @author by hongbf on 2018/2/26.
 */
public class ExcelExportData {
    private Map<String,Object> map;

    public ExcelExportData() {
        this.map = new HashMap<>();
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
