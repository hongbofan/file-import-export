package com.flyread.file.imp0rt.base.impl;


import com.flyread.file.imp0rt.model.BaseImportRow;
import com.flyread.file.imp0rt.model.ImportResponse;

import java.lang.reflect.Field;
import java.util.List;


/**
 * @author by hongbf on 2018/3/21.
 */
public class ToJavaBeanHandler extends BaseRowToRowHandler<BaseImportRow> {

    @Override
    protected void process(BaseImportHandlerContext context, BaseImportRow row,List<Object> out) throws Exception {
        String clazzName = context.pipeline().getRequest().getConfig().getClazzName();
        ImportResponse response = context.pipeline().getResponse();
        response.getResult().add(toJavaBean(clazzName, row));
        response.setImportCount(response.getResult().size());

    }

    protected Object toJavaBean(String clazzName, BaseImportRow row) throws Exception {
        Class<?> clazz = Class.forName(clazzName);
        Field[] declaredFields = clazz.getDeclaredFields();
        Object obj = clazz.getConstructor().newInstance();
        for (Field field : declaredFields) {
            if (row.headerMatch(field.getName())) {
                field.setAccessible(true);
                field.set(obj, row.get(field.getName()));
            }
        }
        return obj;
    }
}
