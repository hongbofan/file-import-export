package com.flyread.file.imp0rt.model;

/**
 * @author by hongbf on 2018/5/2.
 */
public class StringRow extends BaseImportRow {

    private String[] datas;

    public StringRow(String string, String split) {
        this.datas = string.split(split);
    }

    @Override
    public Object get(int idx) {
        return datas[idx];
    }

    @Override
    public Object[] asArray() {
        return datas;
    }

    @Override
    public int size() {
        return datas == null ? 0 : datas.length;
    }
}
