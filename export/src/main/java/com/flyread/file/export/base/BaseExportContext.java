package com.flyread.file.export.base;

import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

import java.io.File;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author by hongbf on 2018/2/28.
 */
public abstract class BaseExportContext {
    private ExportRequest request;
    private ExportResponse response;
    private OutputStream outputStream;
    private ExportTranslate translate;


    public ExportRequest getRequest() {
        return request;
    }

    public void setRequest(ExportRequest request) {
        this.request = request;
    }

    public ExportResponse getResponse() {
        return response;
    }

    public void setResponse(ExportResponse response) {
        this.response = response;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public ExportTranslate getTranslate() {
        return translate;
    }

    public void setTranslate(ExportTranslate translate) {
        this.translate = translate;
    }

}
