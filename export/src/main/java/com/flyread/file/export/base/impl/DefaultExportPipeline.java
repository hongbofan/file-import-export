package com.flyread.file.export.base.impl;



import com.flyread.file.export.base.ExportHandler;
import com.flyread.file.export.base.ExportPipeline;
import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author by hongbf on 2018/3/16.
 */
public class DefaultExportPipeline implements ExportPipeline {
    private final BaseExportHandlerContext head;
    private final BaseExportHandlerContext tail;
    private ExportRequest request;
    private ExportResponse response;
    public DefaultExportPipeline(ExportRequest request) {
        this.head = new HeadContext(this);
        this.tail = new TailContext(this);
        head.next = tail;
        tail.prev = head;
        this.request = request;
        response = new ExportResponse();
    }

    @Override
    public ExportPipeline addFirst(String name, ExportHandler handler) {
        final BaseExportHandlerContext newCtx;
        newCtx = newContext(handler,name == null ? handler.getClass().getName() : name);
        addFirst0(newCtx);
        return this;
    }

/*    @Override
    public ExportPipeline addLast(String name, ExportHandler handler) {
        return null;
    }

    @Override
    public ExportPipeline addBefore(String baseName, String name, ExportHandler handler) {
        return null;
    }

    @Override
    public ExportPipeline addAfter(String baseName, String name, ExportHandler handler) {
        return null;
    }*/

    @Override
    public ExportPipeline addFirst(ExportHandler... handlers) {
        if (handlers == null) {
            throw new NullPointerException("handlers");
        }
        if (handlers.length == 0 || handlers[0] == null) {
            return this;
        }
        int index;
        for (index = 1; index < handlers.length; index ++) {
            if (handlers[index] == null) {
                break;
            }
        }

        for (int i = index - 1; i >= 0; i --) {
            ExportHandler h = handlers[i];
            addFirst(null,h);
        }

        return this;
    }

/*    @Override
    public ExportPipeline addLast(ExportHandler... handlers) {
        return null;
    }

    @Override
    public ExportPipeline remove(ExportHandler handler) {
        return null;
    }

    @Override
    public ExportHandler remove(String name) {
        return null;
    }
*/
    @Override
    public Map<String, ExportHandler> toMap() {
        Map<String, ExportHandler> map = new LinkedHashMap<>();
        BaseExportHandlerContext ctx = head.next;
        for (;;) {
            if (ctx == tail) {
                return map;
            }
            map.put(ctx.getName(), ctx.handler());
            ctx = ctx.next;
        }
    }

    @Override
    public Iterator<Map.Entry<String, ExportHandler>> iterator() {
        return toMap().entrySet().iterator();
    }
    private void addFirst0(BaseExportHandlerContext newCtx) {
        BaseExportHandlerContext nextCtx = head.next;
        newCtx.prev = head;
        newCtx.next = nextCtx;
        head.next = newCtx;
        nextCtx.prev = newCtx;
    }
    private BaseExportHandlerContext newContext(ExportHandler handler,String name) {
        return new DefaultExportHandlerContext(this,handler,name);
    }
    private final class TailContext extends BaseExportHandlerContext implements ExportHandler{
        TailContext(DefaultExportPipeline pipeline) {
            super(pipeline,"tail");
        }

        @Override
        public ExportHandler handler() {
            return this;
        }

        @Override
        public void handleRequest(BaseExportHandlerContext context,Object msg) throws Exception {
        }
    }
    private final class HeadContext extends BaseExportHandlerContext implements ExportHandler{
        HeadContext(DefaultExportPipeline pipeline) {
            super(pipeline,"head");
        }

        @Override
        public void handleRequest(BaseExportHandlerContext context,Object msg) throws Exception {
        }

        @Override
        public ExportHandler handler() {
            return this;
        }
    }

    @Override
    public BaseExportHandlerContext getHead() {
        return head;
    }

    @Override
    public BaseExportHandlerContext getTail() {
        return tail;
    }

    @Override
    public ExportRequest getRequest() {
        return request;
    }
    @Override
    public ExportResponse getResponse() {
        return response;
    }

}
