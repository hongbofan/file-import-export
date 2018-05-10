package com.flyread.file.manager;

import com.flyread.file.config.builder.ImportConfigBuilder;
import com.flyread.file.config.builder.XmlConfigBuilder;
import com.flyread.file.imp0rt.ImportBootstrap;

import javax.xml.bind.JAXBException;
import java.io.InputStream;

/**
 * @author by hongbf on 2018/5/9.
 */
public class Manager {
    private static class LazyHolder {
        private static final Manager INSTANCE = new Manager();
    }
    private Manager (){}
    public static Manager getInstance() {
        return LazyHolder.INSTANCE;
    }

    public ImportBootstrap comsume(InputStream config,String filePath) throws Exception {
        return new ImportConfigBuilder(new XmlConfigBuilder()).build(config,filePath);
    }
}
