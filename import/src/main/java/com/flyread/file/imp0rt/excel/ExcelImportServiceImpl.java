package com.flyread.file.imp0rt.excel;

import com.flyread.file.imp0rt.base.BaseImportContext;
import com.flyread.file.imp0rt.base.ImportHandlerPipeline;
import com.flyread.file.imp0rt.base.ImportService;
import com.flyread.file.imp0rt.model.ImportResponse;

import java.io.File;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ExcelImportServiceImpl implements ImportService{
    private ImportHandlerPipeline pipeline;
    private final ExcelImportContext context;

    public ExcelImportServiceImpl(BaseImportContext context, ImportHandlerPipeline pipeline) {
        this.context = (ExcelImportContext) context;
        this.pipeline = pipeline;
    }

    @Override
    public ImportResponse imp0rt() {

        try {
            pipeline.handleRequest(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return context.getResponse();
    }
}
