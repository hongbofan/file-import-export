package com.flyread.file.imp0rt.model;

import java.util.Iterator;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ImportResponse {
    private int importCount;
    private Object data;
    public int getImportCount() {
        return importCount;
    }

    public void setImportCount(int importCount) {
        this.importCount = importCount;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
