package com.flyread.file.export.model;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author by hongbf on 2018/2/26.
 */
public class ExportRequest {

    private Map<String,Object> exportData;

    private ExportConfig config;
    private OutputStream outputStream;
    private InputStream templateInputStream;

    public Map<String,Object> getExportData() {
        return exportData;
    }

    public void setExportData(Map<String,Object> exportData) {
        this.exportData = exportData;
    }

    public ExportConfig getConfig() {
        return config;
    }

    public void setConfig(ExportConfig config) {
        this.config = config;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public InputStream getTemplateInputStream() {
        return templateInputStream;
    }

    public void setTemplateInputStream(InputStream templateInputStream) {
        this.templateInputStream = templateInputStream;
    }
}
