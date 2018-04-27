package com.flyread.file.export.base.impl;


import com.flyread.file.export.base.ExportHandler;

/**
 * @author by hongbf on 2018/3/16.
 */
public class DefaultExportHandlerContext extends BaseExportHandlerContext {
    private final ExportHandler handler;

    public DefaultExportHandlerContext(DefaultExportPipeline pipeline, ExportHandler handler, String name) {
        super(pipeline,name);
        this.handler = handler;
    }

    @Override
    public ExportHandler handler() {
        return handler;
    }
}
