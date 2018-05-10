package com.flyread.file.config.builder;

import com.flyread.file.config.model.*;
import com.flyread.file.imp0rt.ImportBootstrap;
import com.flyread.file.imp0rt.base.ImportHandler;
import com.flyread.file.imp0rt.base.impl.HeaderMappingHandler;
import com.flyread.file.imp0rt.base.impl.RowHeaderHandler;
import com.flyread.file.imp0rt.base.impl.ToJavaBeanHandler;
import com.flyread.file.imp0rt.base.impl.ValueTypeMappingHandler;
import com.flyread.file.imp0rt.model.ImportConfig;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by hongbf on 2018/5/7.
 */
public class ImportConfigBuilder extends BaseBuilder{

    public ImportConfigBuilder(Builder builder) {
        super(builder);
    }

    public ImportBootstrap build(InputStream config,String filePath) throws Exception {
        Configuration configuration = build(config);
        if (filePath.endsWith(".txt")) {
            return txtBuild(configuration,filePath);
        } else if (filePath.endsWith(".xls") || filePath.endsWith(".xlsx")) {
            return excelBuild(configuration,filePath);
        } else if (filePath.endsWith(".csv")) {
            return csvBuild(configuration,filePath);
        } else {
            throw new RuntimeException("unknown file suffix");
        }
    }
    private ImportBootstrap txtBuild(Configuration configuration,String filePath) {
        TxtType type = configuration.getTxt();
        if (type == null) {
            throw new RuntimeException("没有找到txt相关配置");
        }
        ImportConfig importConfig = new ImportConfig();
        importConfig.setId(configuration.getId());
        importConfig.setSeparator(type.getSeparator());
        importConfig.setImportFileCharset(type.getImportFileCharset());

        List<ImportHandler> handlers = new ArrayList<>();

        handlers.add(new RowHeaderHandler(type.isHasHeader(),type.isSkipBlankRow()));

        mapperBuild(configuration,handlers,importConfig);

        ImportBootstrap bootstrap = new ImportBootstrap();
        bootstrap.initHandle(handlers).initFile(filePath).initConfig(importConfig).build();

        return bootstrap;
    }
    private ImportBootstrap excelBuild(Configuration configuration,String filePath) {
        ExcelType type = configuration.getExcel();
        if (type == null) {
            throw new RuntimeException("没有找到excel相关配置");
        }
        ImportConfig importConfig = new ImportConfig();
        importConfig.setId(configuration.getId());
        importConfig.setSeparator(type.getSeparator());
        importConfig.setImportFileCharset(type.getImportFileCharset());

        List<ImportHandler> handlers = new ArrayList<>();

        handlers.add(new RowHeaderHandler(type.isHasHeader(),type.isSkipBlankRow()));

        mapperBuild(configuration,handlers,importConfig);

        ImportBootstrap bootstrap = new ImportBootstrap();
        bootstrap.initHandle(handlers).initFile(filePath).initConfig(importConfig).build();

        return bootstrap;
    }
    private  ImportBootstrap csvBuild(Configuration configuration,String filePath) {
        CsvType type = configuration.getCsv();
        if (type == null) {
            throw new RuntimeException("没有找到csv相关配置");
        }
        ImportConfig importConfig = new ImportConfig();
        importConfig.setId(configuration.getId());
        importConfig.setSeparator(type.getSeparator());
        importConfig.setImportFileCharset(type.getImportFileCharset());

        List<ImportHandler> handlers = new ArrayList<>();

        handlers.add(new RowHeaderHandler(type.isHasHeader(),type.isSkipBlankRow()));

        mapperBuild(configuration,handlers,importConfig);

        ImportBootstrap bootstrap = new ImportBootstrap();
        bootstrap.initHandle(handlers).initFile(filePath).initConfig(importConfig).build();

        return bootstrap;
    }

    private void mapperBuild(Configuration configuration,List<ImportHandler> handlers,ImportConfig importConfig) {
        if (configuration.getMapper() != null) {
            MapperType mapper = configuration.getMapper();
            List<EntityType> entities = mapper.getEntity();
            if (entities != null) {
                Map<String,String> headerMapper = new HashMap<>(entities.size());
                Map<String,String> valueTypeMapper = new HashMap<>(entities.size());
                entities.forEach(e -> {
                    headerMapper.put(e.getKey(),e.getValue());
                    valueTypeMapper.put(e.getValue(),e.getType());
                });
                handlers.add(new HeaderMappingHandler(headerMapper));
                handlers.add(new ValueTypeMappingHandler(valueTypeMapper));
            }
            if (mapper.getBean() != null) {
                handlers.add(new ToJavaBeanHandler());
                importConfig.setClazzName(mapper.getBean());
            }
        }
    }
}
