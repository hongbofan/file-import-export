package com.flyread.file.export.base;


/**
 * @author by hongbf on 2018/2/26.
 */
public interface ExportHandler {
    void handleRequest(BaseExportContext context) throws Exception;
}
