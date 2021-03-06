package com.flyread.file.imp0rt.base;

import com.flyread.file.imp0rt.base.impl.BaseImportHandlerContext;

/**
 * @author by hongbf on 2018/3/16.
 */
public interface ImportHandlerContext {
    /**
     * 返回该上下文的handler
     * @return
     */
    ImportHandler handler();

    /**
     * 返回该上下文所处的pipeline
     * @return
     */
    ImportPipeline pipeline();

    /**
     * 流转到下一个handler
     * @param msg 流入数据
     * @return
     */
    BaseImportHandlerContext fireChannelRead(Object msg);
}
