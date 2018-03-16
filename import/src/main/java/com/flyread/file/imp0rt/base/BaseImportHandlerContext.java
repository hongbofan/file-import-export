package com.flyread.file.imp0rt.base;


/**
 * @author by hongbf on 2018/3/16.
 */
abstract class BaseImportHandlerContext implements ImportHandlerContext {
    volatile BaseImportHandlerContext next;
    volatile BaseImportHandlerContext prev;
    private final DefaultImportPipeline pipeline;
    private final String name;

    BaseImportHandlerContext(DefaultImportPipeline pipeline,String name) {
        this.pipeline = pipeline;
        this.name = name;
    }

    @Override
    public void write() {

    }

    @Override
    public ImportPipeline pipeline() {
        return pipeline;
    }

    public String getName() {
        return name;
    }
}
