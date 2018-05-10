package com.flyread.file.config.builder;

import com.flyread.file.config.model.Configuration;

import java.io.InputStream;

/**
 * @author by hongbf on 2018/5/9.
 */
public class BaseBuilder implements Builder {
    private final Builder builder;

    public BaseBuilder(Builder builder) {
        this.builder = builder;
    }

    @Override
    public Configuration build(InputStream input) throws Exception {
        return builder.build(input);
    }
}
