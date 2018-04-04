package com.flyread.file.imp0rt.txt;

import com.flyread.file.imp0rt.base.ImportPipeline;
import com.flyread.file.imp0rt.base.ImportService;
import com.flyread.file.imp0rt.base.impl.BaseImportHandlerContext;
import com.flyread.file.imp0rt.base.impl.DefaultImportPipeline;
import com.flyread.file.imp0rt.model.ImportResponse;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author by hongbf on 2018/4/4.
 */
public class TxtImportServiceImpl implements ImportService {
    private ImportPipeline pipeline;
    public TxtImportServiceImpl(ImportPipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public ImportResponse importFile() {
        BaseImportHandlerContext head = pipeline.getHead();
        File file = pipeline.getRequest().getImportFile();
        try {
            Files.lines(Paths.get(file.getAbsolutePath()), Charset.forName("GBK")).forEach(head::fireChannelRead);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pipeline.getResponse();
    }
}
