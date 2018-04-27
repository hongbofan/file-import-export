package com.flyread.file.export.base;

import com.flyread.file.export.base.impl.BaseExportHandlerContext;

/**
 * @author by hongbf on 2018/3/16.
 */
public interface ExportHandlerContext {
    /**
     * 返回该上下文的handler
     * @return
     */
    ExportHandler handler();

    /**
     * 返回该上下文所处的pipeline
     * @return
     */
    ExportPipeline pipeline();

    /**
     * 流转到下一个handler
     * @param msg 流入数据
     * @return
     */
    BaseExportHandlerContext fireChannelRead(Object msg);
}
