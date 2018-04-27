package com.flyread.file.export.base;



import com.flyread.file.export.base.impl.BaseExportHandlerContext;
import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

import java.util.Map;

/**
 * @author by hongbf on 2018/3/16.
 */
public interface ExportPipeline extends Iterable<Map.Entry<String, ExportHandler>>{
    /**
     * 添加单个handler
     * @param name handler名字
     * @param handler 被添加的handler
     * @return
     */
    ExportPipeline addFirst(String name, ExportHandler handler);
    /**
     * 添加多个handler
     * @param handlers 被添加的多个handler
     * @return
     */
    ExportPipeline addFirst(ExportHandler... handlers);

    /**
     * 将该pipeline下的所有handler存入map
     * @return
     */
    Map<String, ExportHandler> toMap();

    /**
     * 获取请求
     * @return
     */
    ExportRequest getRequest();

    /**
     * 获取返回
     * @return
     */
    ExportResponse getResponse();

    /**
     * 获取head上下文
     * @return
     */
    BaseExportHandlerContext getHead();

    /**
     * 获取tail上下文
     * @return
     */
    BaseExportHandlerContext getTail();


    /*    ExportPipeline addLast(ExportHandler... handlers);
    ExportPipeline remove(ExportHandler handler);
    ExportHandler remove(String name);*/
/*    ExportPipeline addLast(String name, ExportHandler handler);
    ExportPipeline addBefore(String baseName, String name, ExportHandler handler);
    ExportPipeline addAfter(String baseName, String name, ExportHandler handler);*/

}
