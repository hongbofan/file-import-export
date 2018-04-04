package com.flyread.file.imp0rt.base.impl;


import com.flyread.file.imp0rt.base.ImportHandler;

/**
 * @author by hongbf on 2018/3/16.
 */
public class DefaultImportHandlerContext extends BaseImportHandlerContext {
    private final ImportHandler handler;

    public DefaultImportHandlerContext(DefaultImportPipeline pipeline, ImportHandler handler, String name) {
        super(pipeline,name);
        this.handler = handler;
    }

    @Override
    public ImportHandler handler() {
        return handler;
    }
}
