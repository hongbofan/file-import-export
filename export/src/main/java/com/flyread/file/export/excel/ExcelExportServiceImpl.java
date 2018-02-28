package com.flyread.file.export.excel;

import com.flyread.file.export.base.BaseExportContext;
import com.flyread.file.export.base.ExportHandlerPipeline;
import com.flyread.file.export.base.ExportService;
import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * @author by hongbf on 2018/2/26.
 */
public class ExcelExportServiceImpl implements ExportService {
    private ExportHandlerPipeline pipeline;
    private final ExcelExportContext context;


    public ExcelExportServiceImpl(ExportHandlerPipeline pipeline,BaseExportContext context) {
        this.context = (ExcelExportContext) context;
        ((ExcelExportContext) context).addConfig(context.getRequest().getTemplateFile());
        this.pipeline = pipeline;
    }

    @Override
    public ExportResponse export() {
        ExportRequest request = context.getRequest();
        ExportResponse response = context.getResponse();
        String path = new SimpleDateFormat("yyyyMMdd").format(new Date())
                + "/" + String.valueOf(Math.abs(new Random().nextLong())) + "/" + request.getOutputFileName() + request.getOutputFileSuffix();
        File output = new File(request.getOutputPath(), path);
        if (output.getParentFile().mkdirs()) {
            try {
                if (output.createNewFile()) {
                    FileOutputStream fos = new FileOutputStream(output);
                    context.setOutputStream(fos);
                    pipeline.handleRequest(context);
                    fos.flush();
                    fos.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (response == null) {
                response = new ExportResponse();
            }
            response.setPath(request.getPrefix() + path);
            return response;
        }
        return null;
    }

    public ExportHandlerPipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(ExportHandlerPipeline pipeline) {
        this.pipeline = pipeline;
    }
}
