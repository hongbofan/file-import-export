package com.flyread.file.export;

import com.flyread.file.export.base.*;
import com.flyread.file.export.excel.DefaultExcelExportHandler;
import com.flyread.file.export.model.ExportRequest;

import java.io.File;
import java.util.List;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ExportBootstrap {
    private  ExportRequest request;
    private  ExportHandlerPipeline pipeline;
    public  ExportService build(ExportType type) {
        return ExportFactory.create(type,pipeline,request);
    }

    public ExportBootstrap initRequest(String outputFileName,String outputFileSuffix,String outputPath,String prefix,File templateFile,Object data) {
        request = new ExportRequest(outputFileName,outputFileSuffix,outputPath,prefix,templateFile,data);
        return this;
    }
    public ExportBootstrap initPipeline() {
        return this.initPipeline(null,false);
    }
    public  ExportBootstrap initPipeline(List<ExportHandler> handlers,boolean useCustomExportHandler) {
        pipeline = new ExportHandlerPipeline();
        if (handlers != null) {
            handlers.forEach(h -> pipeline.addLast(h));
        }
        if (!useCustomExportHandler) {
            pipeline.addLast(new DefaultExcelExportHandler());
        }
        return this;
    }
}
