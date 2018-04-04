package com.flyread.file.imp0rt.base.impl;


import com.flyread.file.imp0rt.base.ImportHandlerContext;
import com.flyread.file.imp0rt.base.ImportPipeline;

/**
 * @author by hongbf on 2018/3/16.
 */
public abstract class BaseImportHandlerContext implements ImportHandlerContext {
    volatile BaseImportHandlerContext next;
    volatile BaseImportHandlerContext prev;
    private final DefaultImportPipeline pipeline;
    private final String name;

    BaseImportHandlerContext(DefaultImportPipeline pipeline,String name) {
        this.pipeline = pipeline;
        this.name = name;
    }

    @Override
    public BaseImportHandlerContext fireChannelRead(Object msg) {
        if (msg == null) {
            throw new NullPointerException("msg");
        }
        final BaseImportHandlerContext next = findContextInbound();
        try {
            next.handler().handleRequest(next,msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    @Override
    public ImportPipeline pipeline() {
        return pipeline;
    }

    public String getName() {
        return name;
    }

    private BaseImportHandlerContext findContextInbound() {
        BaseImportHandlerContext ctx = this;
        ctx = ctx.next;
        return ctx;
    }
}
