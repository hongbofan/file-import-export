package com.flyread.file.imp0rt.base.impl;


import com.flyread.file.imp0rt.base.ImportHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by hongbf on 2018/3/16.
 */
public abstract class BaseReadHandler implements ImportHandler {
    private List<Object> list = new ArrayList<>();
    @Override
    public void handleRequest(BaseImportHandlerContext context, Object msg) throws Exception {
        readLine(context,list, msg);
        list.forEach(context::fireChannelRead);
        list.clear();
    }
    protected abstract void readLine(BaseImportHandlerContext context,List<Object> list,Object msg);
}
