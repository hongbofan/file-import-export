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
    ImportPipeline addFirst(String name, ImportHandler handler);
/*    ImportPipeline addLast(String name, ImportHandler handler);
    ImportPipeline addBefore(String baseName, String name, ImportHandler handler);
    ImportPipeline addAfter(String baseName, String name, ImportHandler handler);*/
    ImportPipeline addFirst(ImportHandler... handlers);
/*    ImportPipeline addLast(ImportHandler... handlers);
    ImportPipeline remove(ImportHandler handler);
    ImportHandler remove(String name);*/
    Map<String, ImportHandler> toMap();

    ImportRequest getRequest();
    ImportResponse getResponse();
    BaseImportHandlerContext getHead();
    BaseImportHandlerContext getTail();
}
