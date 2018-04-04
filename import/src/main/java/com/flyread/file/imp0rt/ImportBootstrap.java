package com.flyread.file.imp0rt;

import com.flyread.file.imp0rt.base.ImportFactory;
import com.flyread.file.imp0rt.base.ImportType;
import com.flyread.file.imp0rt.model.ImportConfig;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by hongbf on 2018/3/14.
 */
public class ImportBootstrap {
    private File file;
    private ImportConfig config;
    private ImportRequest request;
    public ImportBootstrap initFile(String path){
        this.file = new File(path);
        return this;
    }
    public ImportBootstrap initConfig(String configId) {
        this.config = getConfig(configId);
        return this;
    }
    public ImportBootstrap build() {
        this.request = new ImportRequest(this.file);
        this.request.setConfig(this.config);
        return this;
    }
    public ImportResponse start(ImportType type) {
        if (request == null) {
            build();
        }
        return ImportFactory.create(type,this.request).importFile();
    }
    private ImportConfig getConfig(String configId) {
        //TODO
        ImportConfig config = new ImportConfig();
        Map<String,String> map = new HashMap<>();
        map.put("题名","name");
        map.put("ISBN","isbn");
        config.setHeaderMap(map);
        config.setSeparator(" ");
        config.setClazzName("com.flyread.file.imp0rt.base.Book");
        return config;
    }
}
