package com.flyread.file.imp0rt.base;

import com.flyread.file.imp0rt.base.impl.BaseImportHandlerContext;

/**
 * @author by hongbf on 2018/2/28.
 */
public interface ImportHandler {
    /**
     * 处理 Import请求
     * @param context handler上下文
     * @param msg 流入数据
     * @throws Exception
     */
    void handleRequest(BaseImportHandlerContext context, Object msg) throws Exception;
}
