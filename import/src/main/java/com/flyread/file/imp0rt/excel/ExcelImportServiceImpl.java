package com.flyread.file.imp0rt.excel;

import com.flyread.file.imp0rt.base.BaseImportContext;
import com.flyread.file.imp0rt.base.BaseImportHandlerContext;
import com.flyread.file.imp0rt.base.DefaultImportPipeline;
import com.flyread.file.imp0rt.base.ImportService;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;

import java.io.File;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ExcelImportServiceImpl implements ImportService {
    private final ExcelImportContext context;

    public ExcelImportServiceImpl(BaseImportContext context) {
        this.context = (ExcelImportContext) context;
    }

    @Override
    public ImportResponse importFile() {
        try {
            DefaultImportPipeline pipeline = (DefaultImportPipeline) context.getImportPipeline();
            BaseImportHandlerContext head = pipeline.getHead();
            head.fireChannelRead(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return context.getResponse();
    }
}
