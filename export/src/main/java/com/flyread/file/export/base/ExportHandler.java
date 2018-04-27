package com.flyread.file.export.base;


import com.flyread.file.export.base.impl.BaseExportHandlerContext;

/**
 * @author by hongbf on 2018/2/26.
 */
public interface ExportHandler {
    /**
     * 处理 Export请求
     * @param context handler上下文
     * @param msg 流入数据
     * @throws Exception
     */
    void handleRequest(BaseExportHandlerContext context, Object msg) throws Exception;
}
