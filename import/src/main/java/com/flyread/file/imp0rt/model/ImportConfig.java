package com.flyread.file.imp0rt.model;

import java.util.Map;

/**
 * @author by hongbf on 2018/4/2.
 */
public class ImportConfig {

    private String id;
    private String separator;
    private String clazzName;

    private String importFileCharset;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getImportFileCharset() {
        return importFileCharset;
    }

    public void setImportFileCharset(String importFileCharset) {
        this.importFileCharset = importFileCharset;
    }
}
