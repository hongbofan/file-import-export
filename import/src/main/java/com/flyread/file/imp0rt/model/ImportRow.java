package com.flyread.file.imp0rt.model;

/**
 * @author by hongbf on 2018/3/30.
 */
public class ImportRow {
    private String data;
    private boolean isHeader;
    public ImportRow(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }
}
