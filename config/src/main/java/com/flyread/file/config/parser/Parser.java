package com.flyread.file.config.parser;

import java.io.InputStream;

/**
 * @author by hongbf on 2018/5/7.
 */
public interface Parser<T> {
    T parse(InputStream input) throws Exception;
}
