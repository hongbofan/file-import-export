package com.flyread.file.imp0rt.base;


import com.alibaba.fastjson.JSON;
import com.flyread.file.imp0rt.model.ImportRecord;


/**
 * @author by hongbf on 2018/3/21.
 */
public abstract class BaseToJavaBeanHandler implements ImportHandler{
    @Override
    public void handleRequest(BaseImportHandlerContext context,Object msg) throws Exception {
        if (msg instanceof ImportRecord) {
            System.out.println(msg);
            /*JSON.parseObject((String) msg,Book.class);*/
            JSON.parseObject("",Class.forName(""));
        }
    }
}
