package com.flyread.file.export.base;

import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

import java.io.OutputStream;

/**
 * @author by hongbf on 2018/2/26.
 */
public interface ExportHandler {
    void handleRequest(ExportRequest request, ExportResponse response, OutputStream out) throws Exception;
}
