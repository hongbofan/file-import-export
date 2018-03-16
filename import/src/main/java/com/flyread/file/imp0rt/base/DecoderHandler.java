package com.flyread.file.imp0rt.base;

/**
 * @author by hongbf on 2018/3/16.
 */
public class DecoderHandler implements ImportHandler {
    @Override
    public void handleRequest(BaseImportContext context) throws Exception {
        System.out.println("decoder");
    }
}
