package com.flyread.file.imp0rt.base;

/**
 * @author by hongbf on 2018/2/28.
 */
public interface ImportTranslate {
    /**
     * 数据转换
     * @param o 原始数据
     * @return 转换后的数据
     */
    Object translate(Object o);
}
