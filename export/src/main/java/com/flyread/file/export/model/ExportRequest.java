package com.flyread.file.export.model;

/**
 * @author by hongbf on 2018/2/26.
 */
public class ExportRequest {
    private String fileType;

    private String fileName;

    private String exportTemplate;

    private Object exportData;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExportTemplate() {
        return exportTemplate;
    }

    public void setExportTemplate(String exportTemplate) {
        this.exportTemplate = exportTemplate;
    }

    public Object getExportData() {
        return exportData;
    }

    public void setExportData(Object exportData) {
        this.exportData = exportData;
    }

    @Override
    public String toString() {
        return "ExportRequest{" +
                "fileType='" + fileType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", exportTemplate='" + exportTemplate + '\'' +
                ", exportData=" + exportData +
                '}';
    }
}
