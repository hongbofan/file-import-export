package com.flyread.file.imp0rt.base;


import java.util.ArrayList;
import java.util.List;

/**
 * @author by hongbf on 2018/3/16.
 */
public abstract class BaseReadHandler implements ImportHandler {
    private List<Object> list = new ArrayList<>();
    @Override
    public void handleRequest(BaseImportHandlerContext context,Object msg) throws Exception {
        readLine(context,list, msg);
        list.forEach(context::fireChannelRead);
        list.clear();

        /*if(msg instanceof T) {
            System.out.println("decoder");
            Row row = (Row) msg;
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }
                System.out.println(ImportUtil.getCellValue(cell));
                System.out.println(list.size());
                list.add(cell);
            }

        }
        if (msg instanceof String) {
            System.out.println(msg);
            list.add((String) msg);
            context.fireChannelRead(list2);
        }*/
    }
    protected abstract void readLine(BaseImportHandlerContext context,List<Object> list,Object msg);
}
