package com.flyread.file.imp0rt.txt;

import com.flyread.file.imp0rt.base.ImportPipeline;
import com.flyread.file.imp0rt.base.ImportService;
import com.flyread.file.imp0rt.base.impl.BaseImportHandlerContext;
import com.flyread.file.imp0rt.base.impl.DefaultImportPipeline;
import com.flyread.file.imp0rt.model.ImportConfig;
import com.flyread.file.imp0rt.model.ImportResponse;
import com.flyread.file.imp0rt.model.StringRow;
import com.flyread.file.imp0rt.util.ImportUtil;

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
        ImportConfig config = pipeline.getRequest().getConfig();
        File file = pipeline.getRequest().getImportFile();
        try {
            Files.lines(Paths.get(file.getAbsolutePath()), getCharset(config.getImportFileCharset()))
                    .forEach(s -> head.fireChannelRead(new StringRow(s,config.getSeparator())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pipeline.getResponse();
    }
    private Charset getCharset(String charsetName) {
        if (charsetName == null || "".equals(charsetName)) {
            charsetName = ImportUtil.DEFAULT_CHARSET_NAME;
        }
        return Charset.forName(charsetName);
    }
}
