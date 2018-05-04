//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.05.04 时间 05:38:33 PM CST 
//


package com.flyread.file.config.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="txt" type="{http://www.w3school.com.cn}txtType" minOccurs="0"/>
 *         &lt;element name="csv" type="{http://www.w3school.com.cn}csvType" minOccurs="0"/>
 *         &lt;element name="excel" type="{http://www.w3school.com.cn}excelType" minOccurs="0"/>
 *         &lt;element name="mapper" type="{http://www.w3school.com.cn}mapperType" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "configuration")
public class Configuration {

    protected TxtType txt;
    protected CsvType csv;
    protected ExcelType excel;
    protected MapperType mapper;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * 获取txt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TxtType }
     *     
     */
    public TxtType getTxt() {
        return txt;
    }

    /**
     * 设置txt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TxtType }
     *     
     */
    public void setTxt(TxtType value) {
        this.txt = value;
    }

    /**
     * 获取csv属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CsvType }
     *     
     */
    public CsvType getCsv() {
        return csv;
    }

    /**
     * 设置csv属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CsvType }
     *     
     */
    public void setCsv(CsvType value) {
        this.csv = value;
    }

    /**
     * 获取excel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ExcelType }
     *     
     */
    public ExcelType getExcel() {
        return excel;
    }

    /**
     * 设置excel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ExcelType }
     *     
     */
    public void setExcel(ExcelType value) {
        this.excel = value;
    }

    /**
     * 获取mapper属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MapperType }
     *     
     */
    public MapperType getMapper() {
        return mapper;
    }

    /**
     * 设置mapper属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MapperType }
     *     
     */
    public void setMapper(MapperType value) {
        this.mapper = value;
    }

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
