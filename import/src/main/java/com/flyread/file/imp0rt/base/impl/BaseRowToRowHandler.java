package com.flyread.file.imp0rt.base.impl;

import com.flyread.file.imp0rt.base.ImportHandler;
import io.netty.util.internal.TypeParameterMatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by hongbf on 2018/5/2.
 */
public abstract class BaseRowToRowHandler<T> implements ImportHandler{
    private final TypeParameterMatcher matcher;
    protected BaseRowToRowHandler() {
        matcher = TypeParameterMatcher.find(this, BaseRowToRowHandler.class, "T");
    }
    protected BaseRowToRowHandler(Class<? extends T> inboundMessageType) {
        matcher = TypeParameterMatcher.get(inboundMessageType);
    }
    public boolean acceptInboundMessage(Object msg) throws Exception {
        return matcher.match(msg);
    }
    @Override
    public void handleRequest(BaseImportHandlerContext context, Object msg) throws Exception {
        List<Object> out = new ArrayList<>();
        try{
            if (acceptInboundMessage(msg)) {
                @SuppressWarnings("unchecked")
                T cast = (T) msg;
                process(context,cast,out);
            } else {
                out.add(msg);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            int size = out.size();
            for (int i = 0; i < size; i ++) {
                context.fireChannelRead(out.get(i));
            }
        }

    }
    protected abstract void process(BaseImportHandlerContext context,T row,List<Object> out) throws Exception;
}
