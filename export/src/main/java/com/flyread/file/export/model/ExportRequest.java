package com.flyread.file.export.model;

import java.io.File;

/**
 * @author by hongbf on 2018/2/26.
 */
public class ExportRequest {
    private String outputFileName;
    private String outputFileSuffix;
    private String outputPath;
    private String prefix;
    private File templateFile;

    private Object exportData;

    public ExportRequest(String outputFileName,String outputFileSuffix,String outputPath,String prefix,File templateFile, Object exportData) {
        this.outputFileName = outputFileName;
        this.outputFileSuffix = outputFileSuffix;
        this.outputPath = outputPath;
        this.prefix = prefix;
        this.templateFile = templateFile;
        this.exportData = exportData;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public String getOutputFileSuffix() {
        return outputFileSuffix;
    }

    public void setOutputFileSuffix(String outputFileSuffix) {
        this.outputFileSuffix = outputFileSuffix;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public File getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(File templateFile) {
        this.templateFile = templateFile;
    }

    public Object getExportData() {
        return exportData;
    }

    public void setExportData(Object exportData) {
        this.exportData = exportData;
    }
}
