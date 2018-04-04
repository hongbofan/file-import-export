package com.flyread.file.imp0rt.base;

import com.flyread.file.imp0rt.base.impl.BaseImportHandlerContext;

/**
 * @author by hongbf on 2018/3/16.
 */
public interface ImportHandlerContext {
    ImportHandler handler();
    ImportPipeline pipeline();
    BaseImportHandlerContext fireChannelRead(Object msg);
}
