package com.flyread.file.imp0rt.base;

/**
 * @author by hongbf on 2018/2/28.
 */
public interface ImportHandler {
    /**
     * 处理 Import请求
     * @param context Import上下文
     * @throws Exception
     */
    void handleRequest(BaseImportHandlerContext context,Object msg) throws Exception;
}
