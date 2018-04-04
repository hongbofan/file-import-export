package com.flyread.file.imp0rt.base.impl;


import com.flyread.file.imp0rt.base.ImportHandler;
import com.flyread.file.imp0rt.model.ImportRecord;
import com.flyread.file.imp0rt.model.ImportResponse;

import java.lang.reflect.Field;


/**
 * @author by hongbf on 2018/3/21.
 */
public abstract class BaseToJavaBeanHandler implements ImportHandler {
    private ImportRecord header;

    @Override
    public void handleRequest(BaseImportHandlerContext context, Object msg) throws Exception {
        if (msg instanceof ImportRecord) {
            ImportRecord record = (ImportRecord) msg;
            String clazzName = context.pipeline().getRequest().getConfig().getClazzName();
            if (header != null) {
                ImportResponse response = context.pipeline().getResponse();
                response.getResult().add(toJavaBean(clazzName, record));
            }
            if (record.isHeader()) {
                header = record;
            }

        }
    }

    protected Object toJavaBean(String clazzName, ImportRecord record) throws Exception {
        Class<?> clazz = Class.forName(clazzName);
        Field[] declaredFields = clazz.getDeclaredFields();
        Object obj = clazz.getConstructor().newInstance();
        for (Field filed : declaredFields) {
            for (int j = 0; j < header.getList().size(); j++) {
                String s = header.getList().get(j);
                if (filed.getName().equals(s)) {
                    filed.setAccessible(true);
                    filed.set(obj, record.getList().get(j));
                }
            }
        }
        return obj;
    }
}
