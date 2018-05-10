package com.flyread.file.imp0rt;

import com.flyread.file.imp0rt.base.ImportHandler;
import com.flyread.file.imp0rt.base.ImportPipeline;
import com.flyread.file.imp0rt.base.ImportService;
import com.flyread.file.imp0rt.base.impl.DefaultImportPipeline;
import com.flyread.file.imp0rt.excel.ExcelImportServiceImpl;
import com.flyread.file.imp0rt.model.ImportConfig;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;
import com.flyread.file.imp0rt.txt.TxtImportServiceImpl;

import java.io.File;
import java.util.List;

/**
 * @author by hongbf on 2018/3/14.
 */
public class ImportBootstrap {
    private File file;
    private ImportConfig config;
    private ImportRequest request;
    private ImportService service;
    private List<ImportHandler> handlers;
    public ImportBootstrap initHandle(List<ImportHandler> handlers) {
        this.handlers = handlers;
        return this;
    }
    public ImportResponse start() {
        if (this.request == null) {
            build();
        }
        return this.service.importFile();
    }
    public ImportBootstrap initFile(String path) {
        this.file = new File(path);
        return this;
    }

    public ImportBootstrap build() {
        this.request = new ImportRequest(this.file);
        this.request.setConfig(this.config);
        ImportPipeline pipeline = new DefaultImportPipeline(this.request);
        handlers.forEach(pipeline::addLast);

        if (file.getName().endsWith(".txt")) {
            this.service = new TxtImportServiceImpl(pipeline);
        } else if (file.getName().endsWith(".xls") || this.file.getName().endsWith(".xlsx")) {
            this.service = new ExcelImportServiceImpl(pipeline);
        }
        return this;
    }
    public ImportBootstrap initConfig(ImportConfig config) {
        this.config = config;
        return this;
    }
}
