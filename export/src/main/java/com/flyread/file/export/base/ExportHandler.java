package com.flyread.file.export.base;


/**
 * @author by hongbf on 2018/2/26.
 */
public interface ExportHandler {
    /**
     * 处理Export请求
     * @param context Export上下文
     * @throws Exception
     */
    void handleRequest(BaseExportContext context) throws Exception;
}
