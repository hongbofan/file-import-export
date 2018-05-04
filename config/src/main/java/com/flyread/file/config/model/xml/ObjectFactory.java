//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.05.04 时间 05:38:33 PM CST 
//


package com.flyread.file.config.model.xml;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.flyread.file.config.model.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.flyread.file.config.model.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Configuration }
     * 
     */
    public Configuration createConfiguration() {
        return new Configuration();
    }

    /**
     * Create an instance of {@link TxtType }
     * 
     */
    public TxtType createTxtType() {
        return new TxtType();
    }

    /**
     * Create an instance of {@link CsvType }
     * 
     */
    public CsvType createCsvType() {
        return new CsvType();
    }

    /**
     * Create an instance of {@link ExcelType }
     * 
     */
    public ExcelType createExcelType() {
        return new ExcelType();
    }

    /**
     * Create an instance of {@link MapperType }
     * 
     */
    public MapperType createMapperType() {
        return new MapperType();
    }

    /**
     * Create an instance of {@link EntityType }
     * 
     */
    public EntityType createEntityType() {
        return new EntityType();
    }

}
