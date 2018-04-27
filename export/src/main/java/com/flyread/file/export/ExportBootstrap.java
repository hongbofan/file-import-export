package com.flyread.file.export;

import com.flyread.file.export.base.*;
import com.flyread.file.export.model.ExportConfig;
import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ExportBootstrap {
    private  ExportRequest request;
    private ExportConfig config;
    private Map<String,Object> data;
    private FileOutputStream fos;
    private String responsePath;
    public ExportResponse start(ExportType type){
        if (this.request == null) {
            build();
        }
        return ExportFactory.create(type,this.request).exportFile();
    }
    public ExportBootstrap initData(Map<String,Object> data) {
        this.data = data;
        return this;
    }

    public ExportBootstrap initConfig(String configId) {
        this.config = getConfig(configId);
        return this;
    }
    public ExportBootstrap build(){
        this.request = new ExportRequest();
        this.request.setConfig(this.config);
        this.request.setExportData(this.data);
        this.request.setOutputStream(this.fos);
        //this.request.setResponsePath(this.responsePath);
        return this;
    }

    private ExportConfig getConfig(String configId) {
        ExportConfig config = new ExportConfig();
        config.setOutputFileName("1234");
        config.setOutputFileSuffix(".txt");
        config.setOutputPath("C:\\Users\\DELL\\Desktop\\新建文件夹");
        config.setPrefix("/download/");
        config.setTemplateFilePath("C:\\Users\\DELL\\Desktop\\新建文件夹\\template.xls");
        Map<String,String> headers = new HashMap<>();
        headers.put("code","编号");
        headers.put("name","姓名");
        headers.put("sex","性别");
        headers.put("createTime","创建时间");
        headers.put("year","年龄");
        config.setHeaders(headers);


        return config;
    }
}
