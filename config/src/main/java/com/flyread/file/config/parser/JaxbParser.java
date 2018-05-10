package com.flyread.file.config.parser;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

/**
 * @author by hongbf on 2018/5/7.
 */
public class JaxbParser<T> implements Parser{
    private final Unmarshaller unmarshaller;

    public JaxbParser(Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        this.unmarshaller = jaxbContext.createUnmarshaller();
    }

    @Override
    public T parse(InputStream input) throws JAXBException {
        @SuppressWarnings("unchecked")
        T cast = (T) unmarshaller.unmarshal(input);
        return cast;
    }
}
