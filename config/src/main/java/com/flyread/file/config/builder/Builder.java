package com.flyread.file.config.builder;

import com.flyread.file.config.model.Configuration;

import java.io.InputStream;

/**
 * @author by hongbf on 2018/5/7.
 */
public interface Builder {
    Configuration build(InputStream input) throws Exception;
}
