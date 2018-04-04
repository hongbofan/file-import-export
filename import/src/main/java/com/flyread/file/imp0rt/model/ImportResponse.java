package com.flyread.file.imp0rt.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ImportResponse {
    private int importCount;
    private List<Object> result;

    public ImportResponse() {
        result = new ArrayList<>();
    }

    public int getImportCount() {
        return importCount;
    }

    public void setImportCount(int importCount) {
        this.importCount = importCount;
    }

    public List<Object> getResult() {
        return result;
    }

    public void setResult(List<Object> result) {
        this.result = result;
    }
}
