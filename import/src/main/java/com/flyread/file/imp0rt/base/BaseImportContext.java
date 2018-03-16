package com.flyread.file.imp0rt.base;

import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;

import java.io.File;
import java.util.Iterator;

/**
 * @author by hongbf on 2018/2/28.
 */
public abstract class BaseImportContext {
    private ImportRequest request;
    private ImportResponse response;
    private Iterator iterator;
    private ImportHandlerPipeline pipeline;

    private ImportPipeline importPipeline;

    public ImportRequest getRequest() {
        return request;
    }

    public void setRequest(ImportRequest request) {
        this.request = request;
    }

    public ImportResponse getResponse() {
        return response;
    }

    public void setResponse(ImportResponse response) {
        this.response = response;
    }

    public Iterator getIterator() {
        return iterator;
    }

    public void setIterator(Iterator iterator) {
        this.iterator = iterator;
    }

    public ImportHandlerPipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(ImportHandlerPipeline pipeline) {
        this.pipeline = pipeline;
    }

    public ImportPipeline getImportPipeline() {
        return importPipeline;
    }

    public void setImportPipeline(ImportPipeline importPipeline) {
        this.importPipeline = importPipeline;
    }
}
