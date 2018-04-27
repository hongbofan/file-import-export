package com.flyread.file.export.txt;

import com.flyread.file.export.base.ExportPipeline;
import com.flyread.file.export.base.ExportService;
import com.flyread.file.export.base.impl.BaseExportHandlerContext;
import com.flyread.file.export.model.ExportConfig;
import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;


/**
 * @author by hongbf on 2018/2/26.
 */
public class TxtExportServiceImpl <E> implements ExportService {
    private final ExportPipeline pipeline;

    public TxtExportServiceImpl(ExportPipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public ExportResponse exportFile() {
        BaseExportHandlerContext head = pipeline.getHead();
        ExportResponse response = pipeline.getResponse();
        ExportRequest request = pipeline.getRequest();
        ExportConfig config = request.getConfig();
        String path = getRelativePath(config);
        OutputStream outputStream = getOutputStream(config, path);
        InputStream inputStream = getTemplateInputStream(config);
        request.setOutputStream(outputStream);
        request.setTemplateInputStream(inputStream);

        try {
            Collection<?> exportData = (Collection<?>) request.getExportData().get("list");
            exportData.forEach(head::fireChannelRead);
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
