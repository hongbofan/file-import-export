package com.flyread.file.imp0rt.base;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;

/**
 * @author by hongbf on 2018/3/16.
 */
public interface ImportHandlerContext {
    ImportHandler handler();
    ImportPipeline pipeline();
    BaseImportHandlerContext fireChannelRead(Object msg);
}
