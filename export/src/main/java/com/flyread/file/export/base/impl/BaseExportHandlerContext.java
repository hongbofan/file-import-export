package com.flyread.file.export.base.impl;

import com.flyread.file.export.base.ExportHandlerContext;
import com.flyread.file.export.base.ExportPipeline;

/**
 * @author by hongbf on 2018/3/16.
 */
public abstract class BaseExportHandlerContext implements ExportHandlerContext {
    volatile BaseExportHandlerContext next;
    volatile BaseExportHandlerContext prev;
    private final DefaultExportPipeline pipeline;
    private final String name;

    BaseExportHandlerContext(DefaultExportPipeline pipeline, String name) {
        this.pipeline = pipeline;
        this.name = name;
    }

    @Override
    public BaseExportHandlerContext fireChannelRead(Object msg) {
        if (msg == null) {
            throw new NullPointerException("msg");
        }
        final BaseExportHandlerContext next = findContextInbound();
        try {
            next.handler().handleRequest(next,msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    @Override
    public ExportPipeline pipeline() {
        return pipeline;
    }

    public String getName() {
        return name;
    }

    private BaseExportHandlerContext findContextInbound() {
        BaseExportHandlerContext ctx = this;
        ctx = ctx.next;
        return ctx;
    }
}
