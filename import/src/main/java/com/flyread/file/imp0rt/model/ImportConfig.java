package com.flyread.file.imp0rt.model;

import java.util.Map;

/**
 * @author by hongbf on 2018/4/2.
 */
public class ImportConfig {
    private String separator;
    private Map<String,String> headerMap;
    private String clazzName;

    private String importFileCharset;

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    public void setHeaderMap(Map<String, String> headerMap) {
        this.headerMap = headerMap;
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
