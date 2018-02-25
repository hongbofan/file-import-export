package com.flyread.file.imp0rt.base;

import com.flyread.file.imp0rt.model.ImportRecord;

import java.util.Iterator;

/**
 * @author by hongbf on 2018/2/25.
 */
public interface ImportReader<E> {
    /**
     * 返回是否有可读的记录
     *
     * @return
     */
    boolean hasNext();

    /**
     * 返回当前读取的记录
     *
     * @return ImportRecord  import记录
     */
    E next();

}
