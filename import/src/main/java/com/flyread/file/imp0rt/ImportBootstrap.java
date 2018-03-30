package com.flyread.file.imp0rt;

import com.flyread.file.imp0rt.base.*;

import com.flyread.file.imp0rt.excel.ExcelImportTranslate;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javafx.scene.input.KeyCode.M;

/**
 * @author by hongbf on 2018/3/14.
 */
public class ImportBootstrap {
/*    private ImportRequest request;
    private ImportHandlerPipeline pipeline;
    public ImportService build(ImportType type) {
        return ImportFactory.create(type,pipeline,request);
    }
    public ImportBootstrap initRequest(File importFile) {
        return initRequest(importFile,0,0,null);
    }
    public ImportBootstrap initRequest(File importFile,int selectSheet) {
        return initRequest(importFile,selectSheet,0,null);
    }
    public ImportBootstrap initRequest(File importFile,ImportTranslate translate) {
        return initRequest(importFile,0,0,translate);
    }
    public ImportBootstrap initRequest(File importFile, int selectSheet, int startRowNum, ImportTranslate translate) {
        request = new ImportRequest(importFile);
        request.setSelectSheet(selectSheet);
        request.setStartRowNum(startRowNum);
        request.setTranslate(translate);
        return this;
    }

    public ImportBootstrap initPipeline() {
        initPipeline(null,false);
        return this;
    }
    public ImportBootstrap initPipeline(List<ImportHandler> handlers, boolean useCustomExportHandler) {
        pipeline = new ImportHandlerPipeline();
        if (handlers != null) {
            handlers.forEach(h -> pipeline.addLast(h));
        }
        if (!useCustomExportHandler) {
            pipeline.addLast(new DefaultExcelImportHandler());
        }
        return this;
    }*/
}
