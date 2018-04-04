package com.flyread.file.imp0rt.model;

import java.io.File;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ImportRequest {

    private File importFile;
    private ImportConfig config;

    public ImportRequest(File importFile) {
        this.importFile = importFile;
    }

    public File getImportFile() {
        return importFile;
    }

    public void setImportFile(File importFile) {
        this.importFile = importFile;
    }

    public ImportConfig getConfig() {
        return config;
    }

    public void setConfig(ImportConfig config) {
        this.config = config;
    }
}
