package com.flyread.file.export.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author by hongbf on 2018/2/26.
 */
public class ExcelData {
    private List<String> headers;
    private String title;
    private Map<String,Object> map;
    private String sheetName;
    private List<Consumer<HSSFWorkbook>> styleFuncList;
    public ExcelData() {
        this.sheetName = "0";
        this.headers = new ArrayList<>();
        this.map = new HashMap<>();
        this.title = "";
        this.styleFuncList = new ArrayList<>();
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<Consumer<HSSFWorkbook>> getStyleFuncList() {
        return styleFuncList;
    }

    public void setStyleFuncList(List<Consumer<HSSFWorkbook>> styleFuncList) {
        this.styleFuncList = styleFuncList;
    }
}
