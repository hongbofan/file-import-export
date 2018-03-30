package com.flyread.file.imp0rt.txt;


import com.flyread.file.imp0rt.base.BaseImportHandlerContext;
import com.flyread.file.imp0rt.base.BaseReadHandler;
import com.flyread.file.imp0rt.model.ImportRow;

import java.util.List;

/**
 * @author by hongbf on 2018/3/21.
 */
public class TxtReadLineHandler extends BaseReadHandler {

    @Override
    protected void readLine(BaseImportHandlerContext context, List<Object> list, Object msg) {
        System.out.println("txt decode");
        if (msg instanceof String) {
            ImportRow row = new ImportRow((String) msg);
            list.add(row);
        }
    }
}
