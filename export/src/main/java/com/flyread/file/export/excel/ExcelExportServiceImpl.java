package com.flyread.file.export.excel;

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
    private final File output;
    private final String prefix;

    public ExcelExportServiceImpl(File output, String prefix) {
        this(new ExportHandlerPipeline().addLast(new DefaultExcelExportHandler(null,null)),output,prefix);
    }

    public ExcelExportServiceImpl(ExportHandlerPipeline pipeline, File output, String prefix) {
        this.pipeline = pipeline;
        this.output = output;
        this.prefix = prefix;
    }

    @Override
    public ExportResponse export(ExportRequest request,ExportResponse response) {


        String path = new SimpleDateFormat("yyyyMMdd").format(new Date())
                + "/" + String.valueOf(Math.abs(new Random().nextLong())) + "/" + request.getFileName() + request.getFileType();
        File output = new File(this.output, path);
        if (output.getParentFile().mkdirs()) {
            try {
                if (output.createNewFile()) {
                    FileOutputStream fos = new FileOutputStream(output);
                    pipeline.handleRequest(request,response,fos);
                    fos.flush();
                    fos.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (response == null) {
                response = new ExportResponse();
            }
            response.setPath(prefix + path);
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
