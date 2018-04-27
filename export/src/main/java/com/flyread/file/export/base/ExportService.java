package com.flyread.file.export.base;

import com.flyread.file.export.model.ExportConfig;
import com.flyread.file.export.model.ExportResponse;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

/**
 * @author  hongbf on 2018/2/11.
 */
public interface ExportService {
    /**
     * 导出文件
     * @return ExportResponse
     */
    ExportResponse exportFile();

    /**
     * 生成文件相对路径
     * @param config
     * @return
     */
    default String getRelativePath(ExportConfig config) {
        return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)
                + "/" + String.valueOf(Math.abs(new Random().nextLong())) + "/" + config.getOutputFileName() + config.getOutputFileSuffix();
    }

    /**
     * 获取配置模板文件输入流
     * @param config
     * @return
     */
    default InputStream getTemplateInputStream(ExportConfig config) {
        if (config.getTemplateFilePath() == null || "".equals(config.getTemplateFilePath())) {
            return null;
        }
        try {
            return new FileInputStream(new File(config.getTemplateFilePath()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取配置输出文件输出流
     * @param config
     * @param relativePath
     * @return
     */
    default OutputStream getOutputStream(ExportConfig config,String relativePath) {
        File output = new File(config.getOutputPath(), relativePath);

        if (output.getParentFile().mkdirs()) {
            try {
                if (output.createNewFile()) {
                    return new FileOutputStream(output);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
