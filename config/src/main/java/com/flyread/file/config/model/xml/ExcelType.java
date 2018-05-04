//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.05.04 时间 05:38:33 PM CST 
//


package com.flyread.file.config.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>excelType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="excelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="separator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importFileCharset" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "excelType", propOrder = {

})
public class ExcelType {

    @XmlElement(defaultValue = " ")
    protected String separator;
    @XmlElement(defaultValue = "utf-8")
    protected String importFileCharset;

    /**
     * 获取separator属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeparator() {
        return separator;
    }

    /**
     * 设置separator属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeparator(String value) {
        this.separator = value;
    }

    /**
     * 获取importFileCharset属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportFileCharset() {
        return importFileCharset;
    }

    /**
     * 设置importFileCharset属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportFileCharset(String value) {
        this.importFileCharset = value;
    }

}
