package com.flyread.file.imp0rt.base;

/**
 * @author by hongbf on 2018/2/28.
 */
public interface ImportHandler {
    void handleRequest(BaseImportContext context) throws Exception;
}
