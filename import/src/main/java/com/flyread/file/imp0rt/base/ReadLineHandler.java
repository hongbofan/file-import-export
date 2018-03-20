package com.flyread.file.imp0rt.base;

/**
 * @author by hongbf on 2018/3/16.
 */
public class ReadLineHandler implements ImportHandler {
    @Override
    public void handleRequest(BaseImportHandlerContext context,Object msg) throws Exception {
        System.out.println("readline");

    }
}
