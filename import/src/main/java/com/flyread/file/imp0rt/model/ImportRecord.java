package com.flyread.file.imp0rt.model;

import java.util.List;

/**
 * @author  hongbf on 2018/2/25.
 */
public class ImportRecord {
    private List<String> list;

    private boolean isHeader;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }


    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        list.forEach(e -> sb.append((e == null ? "null" : e.toString()) + "|"));
        return sb.toString();
    }
}
