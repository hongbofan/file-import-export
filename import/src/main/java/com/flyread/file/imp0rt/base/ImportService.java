package com.flyread.file.imp0rt.base;

import com.flyread.file.imp0rt.model.ImportResponse;

/**
 * @author by hongbf on 2018/2/28.
 */
public interface ImportService {
    /**
     * 导入文件
     * @return ImportResponse
     */
    ImportResponse importFile();
}
