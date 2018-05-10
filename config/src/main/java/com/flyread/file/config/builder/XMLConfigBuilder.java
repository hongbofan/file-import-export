package com.flyread.file.config.builder;

import com.flyread.file.config.model.Configuration;
import com.flyread.file.config.parser.JaxbParser;

import javax.xml.bind.JAXBException;
import java.io.InputStream;

/**
 * @author by hongbf on 2018/5/7.
 */
public class XmlConfigBuilder implements Builder{

    private JaxbParser parser;

    public XmlConfigBuilder() throws JAXBException {
        parser = new JaxbParser<>(Configuration.class);
    }

    @Override
    public Configuration build(InputStream input) throws JAXBException {
        return (Configuration) parser.parse(input);
    }
}
