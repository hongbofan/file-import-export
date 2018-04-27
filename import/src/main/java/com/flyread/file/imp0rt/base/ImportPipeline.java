package com.flyread.file.imp0rt.base;



import com.flyread.file.imp0rt.base.impl.BaseImportHandlerContext;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;

import java.util.Map;

/**
 * @author by hongbf on 2018/3/16.
 */
public interface ImportPipeline extends Iterable<Map.Entry<String, ImportHandler>>{
    /**
     * 添加单个handler
     * @param name handler名字
     * @param handler 被添加的handler
     * @return
     */
    ImportPipeline addFirst(String name, ImportHandler handler);
    /**
     * 添加多个handler
     * @param handlers 被添加的多个handler
     * @return
     */
    ImportPipeline addFirst(ImportHandler... handlers);

    /**
     * 将该pipeline下的所有handler存入map
     * @return
     */
    Map<String, ImportHandler> toMap();

    /**
     * 获取请求
     * @return
     */
    ImportRequest getRequest();

    /**
     * 获取返回
     * @return
     */
    ImportResponse getResponse();

    /**
     * 获取head上下文
     * @return
     */
    BaseImportHandlerContext getHead();

    /**
     * 获取tail上下文
     * @return
     */
    BaseImportHandlerContext getTail();


    /*    ImportPipeline addLast(ImportHandler... handlers);
    ImportPipeline remove(ImportHandler handler);
    ImportHandler remove(String name);*/
/*    ImportPipeline addLast(String name, ImportHandler handler);
    ImportPipeline addBefore(String baseName, String name, ImportHandler handler);
    ImportPipeline addAfter(String baseName, String name, ImportHandler handler);*/

}
