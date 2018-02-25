package com.flyread.file.imp0rt.model;

import java.util.List;

/**
 * @author  hongbf on 2018/2/25.
 */
public class ImportRecord {
    private List<Object> list;

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        list.forEach(e -> sb.append((e == null ? "null" : e.toString()) + "|"));
        return sb.toString();
    }
}
