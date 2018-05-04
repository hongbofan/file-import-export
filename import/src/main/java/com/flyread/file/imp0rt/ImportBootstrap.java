package com.flyread.file.imp0rt;

import com.flyread.file.imp0rt.base.ImportPipeline;
import com.flyread.file.imp0rt.base.ImportService;
import com.flyread.file.imp0rt.base.impl.DefaultImportPipeline;
import com.flyread.file.imp0rt.base.impl.HeaderMappingHandler;
import com.flyread.file.imp0rt.base.impl.RowHeaderHandler;
import com.flyread.file.imp0rt.base.impl.ToJavaBeanHandler;
import com.flyread.file.imp0rt.excel.ExcelImportServiceImpl;
import com.flyread.file.imp0rt.model.ImportConfig;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;
import com.flyread.file.imp0rt.txt.TxtImportServiceImpl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author by hongbf on 2018/3/14.
 */
public class ImportBootstrap {
    private File file;
    private ImportConfig config;
    private ImportRequest request;
    private ImportService service;
    private Consumer<ImportPipeline> initializer;
    public ImportBootstrap initHandle(Consumer<ImportPipeline> initializer) {
        this.initializer = initializer;
        return this;
    }
    public ImportResponse start() {
        if (this.request == null) {
            build();
        }
        return this.service.importFile();
    }
    public ImportBootstrap initFile(String path) {
        this.file = new File(path);
        return this;
    }

    public ImportBootstrap build() {
        this.request = new ImportRequest(this.file);
        this.request.setConfig(this.config);
        ImportPipeline pipeline = new DefaultImportPipeline(this.request);
        initializer.accept(pipeline);

        if (file.getName().endsWith(".txt")) {
            this.service = new TxtImportServiceImpl(pipeline);
        } else if (file.getName().endsWith(".xls") || this.file.getName().endsWith(".xlsx")) {
            this.service = new ExcelImportServiceImpl(pipeline);
        }
        return this;
    }
    public ImportBootstrap initConfig(String configId) {
        this.config = getConfig(configId);
        return this;
    }
    private ImportConfig getConfig(String configId) {
        //TODO
        ImportConfig config = new ImportConfig();
        Map<String, String> map = new HashMap<>();
        map.put("题名", "name");
        map.put("ISBN", "isbn");
        map.put("责任者", "infoAuthor");
        map.put("出版社", "infoPublisher");
        map.put("出版日期", "infoPubdate");
        map.put("单价", "infoPrice");
        map.put("已订数量", "orderCount");
        config.setHeaderMap(map);
        config.setSeparator(" ");
        config.setClazzName("com.flyread.file.imp0rt.base.Book");
        config.setImportFileCharset("GBK");
        return config;
    }
}
