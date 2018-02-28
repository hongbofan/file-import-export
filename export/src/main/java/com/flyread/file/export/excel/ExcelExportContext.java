package com.flyread.file.export.excel;

import com.flyread.file.export.base.BaseExportContext;
import org.jxls.util.JxlsHelper;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ExcelExportContext extends BaseExportContext {

    private final JxlsHelper jxlsHelper;
    private final Map<String, File> configMap;

    public ExcelExportContext() {
        this.configMap = new ConcurrentHashMap<>();
        this.jxlsHelper = JxlsHelper.getInstance();
    }

    public void addConfig(File config) {
        if (config == null) {
            return;
        }
        if (config.isDirectory()) {
            File[] files = config.listFiles();
            if (files != null) {
                for (File con : files) {
                    addConfig(con);
                }
            }
        } else {
            String name = config.getName();
            if (configMap.containsKey(name)) {
                throw new RuntimeException("重复的注册类型:"
                        + name + ",已注册文件:" + configMap.get(name).getAbsolutePath()
                        + ",当前文件:" + config.getAbsolutePath());
            } else {
                configMap.put(name, config);
            }

        }
    }

    public File getConfig(String typeName) {
        return configMap.get(typeName);
    }

    public JxlsHelper getJxlsHelper() {
        return jxlsHelper;
    }
}
