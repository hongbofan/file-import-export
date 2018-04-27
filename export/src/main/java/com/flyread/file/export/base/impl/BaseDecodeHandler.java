package com.flyread.file.export.base.impl;

import com.flyread.file.export.base.ExportHandler;
import com.flyread.file.export.model.ExportConfig;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author by hongbf on 2018/4/17.
 */
public abstract class BaseDecodeHandler implements ExportHandler {
    @Override
    public void handleRequest(BaseExportHandlerContext context, Object msg) throws Exception {
        context.fireChannelRead(decode(context.pipeline().getRequest().getConfig(), msg));
    }
    protected String decode(ExportConfig config,Object msg) throws Exception{
        Map<String, String> headers = config.getHeaders();
        Field[] declaredFields = msg.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (Field field : declaredFields) {
            if (headers.containsKey(field.getName())) {
                field.setAccessible(true);
                sb.append(field.get(msg).toString()).append(" ");
            }
        }
        return sb.toString();
    }
}
