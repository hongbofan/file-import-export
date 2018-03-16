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
    /**
     *  导出请求
     */
    private ExportRequest request;
    /**
     *  导出返回
     */
    private ExportResponse response;
    /**
     *  输出流
     */
    private OutputStream outputStream;

    private ExportHandlerPipeline pipeline;


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

    public ExportHandlerPipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(ExportHandlerPipeline pipeline) {
        this.pipeline = pipeline;
    }
}
