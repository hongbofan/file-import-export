package com.flyread.file.export.excel;

import com.flyread.file.export.base.ExportPipeline;
import com.flyread.file.export.base.ExportService;
import com.flyread.file.export.base.impl.BaseExportHandlerContext;
import com.flyread.file.export.model.ExportConfig;
import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.apache.commons.jexl2.parser.ParserConstants.ne;


/**
 * @author by hongbf on 2018/2/26.
 */
public class ExcelExportServiceImpl implements ExportService {
    private final ExportPipeline pipeline;

    public ExcelExportServiceImpl(ExportPipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public ExportResponse exportFile() {
        BaseExportHandlerContext head = pipeline.getHead();
        ExportResponse response = pipeline.getResponse();
        ExportRequest request = pipeline.getRequest();
        ExportConfig config = request.getConfig();
        String path = getRelativePath(config);
        OutputStream outputStream = getOutputStream(config,path);
        InputStream inputStream = getTemplateInputStream(config);

        request.setOutputStream(outputStream);
        request.setTemplateInputStream(inputStream);
        try {
            head.fireChannelRead(request.getExportData());
            outputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        response.setPath(path);
        return response;
    }
}