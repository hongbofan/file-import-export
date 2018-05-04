package com.flyread.file.imp0rt.base.impl;



import com.flyread.file.imp0rt.base.ImportHandler;
import com.flyread.file.imp0rt.base.ImportPipeline;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author by hongbf on 2018/3/16.
 */
public class DefaultImportPipeline implements ImportPipeline {
    private final BaseImportHandlerContext head;
    private final BaseImportHandlerContext tail;
    private ImportRequest request;
    private ImportResponse response;
    public DefaultImportPipeline(ImportRequest request) {
        this.head = new HeadContext(this);
        this.tail = new TailContext(this);
        head.next = tail;
        tail.prev = head;
        response = new ImportResponse();
        this.request = request;
    }

    @Override
    public ImportPipeline addFirst(String name, ImportHandler handler) {
        final BaseImportHandlerContext newCtx;
        newCtx = newContext(handler,name == null ? handler.getClass().getName() : name);
        addFirst0(newCtx);
        return this;
    }

/*    @Override
    public ImportPipeline addLast(String name, ImportHandler handler) {
        return null;
    }

    @Override
    public ImportPipeline addBefore(String baseName, String name, ImportHandler handler) {
        return null;
    }

    @Override
    public ImportPipeline addAfter(String baseName, String name, ImportHandler handler) {
        return null;
    }*/

    @Override
    public ImportPipeline addFirst(ImportHandler... handlers) {
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
            ImportHandler h = handlers[i];
            addFirst(null,h);
        }

        return this;
    }

/*    @Override
    public ImportPipeline addLast(ImportHandler... handlers) {
        return null;
    }

    @Override
    public ImportPipeline remove(ImportHandler handler) {
        return null;
    }

    @Override
    public ImportHandler remove(String name) {
        return null;
    }
*/
    @Override
    public Map<String, ImportHandler> toMap() {
        Map<String, ImportHandler> map = new LinkedHashMap<>();
        BaseImportHandlerContext ctx = head.next;
        for (;;) {
            if (ctx == tail) {
                return map;
            }
            map.put(ctx.getName(), ctx.handler());
            ctx = ctx.next;
        }
    }

    @Override
    public Iterator<Map.Entry<String, ImportHandler>> iterator() {
        return toMap().entrySet().iterator();
    }
    private void addFirst0(BaseImportHandlerContext newCtx) {
        BaseImportHandlerContext nextCtx = head.next;
        newCtx.prev = head;
        newCtx.next = nextCtx;
        head.next = newCtx;
        nextCtx.prev = newCtx;
    }
    private BaseImportHandlerContext newContext(ImportHandler handler,String name) {
        return new DefaultImportHandlerContext(this,handler,name);
    }
    private final class TailContext extends BaseImportHandlerContext implements ImportHandler{
        TailContext(DefaultImportPipeline pipeline) {
            super(pipeline,"tail");
        }

        @Override
        public ImportHandler handler() {
            return this;
        }

        @Override
        public void handleRequest(BaseImportHandlerContext context,Object msg) throws Exception {
        }
    }
    private final class HeadContext extends BaseImportHandlerContext implements ImportHandler{
        HeadContext(DefaultImportPipeline pipeline) {
            super(pipeline,"head");
        }

        @Override
        public void handleRequest(BaseImportHandlerContext context,Object msg) throws Exception {
        }

        @Override
        public ImportHandler handler() {
            return this;
        }
    }

    @Override
    public BaseImportHandlerContext getHead() {
        return head;
    }

    @Override
    public BaseImportHandlerContext getTail() {
        return tail;
    }

    @Override
    public ImportRequest getRequest() {
        return request;
    }
    @Override
    public ImportResponse getResponse() {
        return response;
    }
}
