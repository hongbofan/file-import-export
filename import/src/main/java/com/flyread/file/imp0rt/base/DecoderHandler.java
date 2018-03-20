package com.flyread.file.imp0rt.base;

import org.apache.poi.ss.usermodel.Row;

/**
 * @author by hongbf on 2018/3/16.
 */
public class DecoderHandler implements ImportHandler {
    @Override
    public void handleRequest(BaseImportHandlerContext context,Object msg) throws Exception {
        System.out.println("decoder");
        if(msg instanceof Row) {

            context.fireChannelRead(msg);
        }
    }
}
