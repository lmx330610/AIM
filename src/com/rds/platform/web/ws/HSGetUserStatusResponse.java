
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence>
 *         &lt;element name="HS_GetUserStatusResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "hsGetUserStatusResult"
})
@XmlRootElement(name = "HS_GetUserStatusResponse")
public class HSGetUserStatusResponse {

    @XmlElement(name = "HS_GetUserStatusResult")
    protected int hsGetUserStatusResult;

    /**
     * 获取hsGetUserStatusResult属性的值。
     * 
     */
    public int getHSGetUserStatusResult() {
        return hsGetUserStatusResult;
    }

    /**
     * 设置hsGetUserStatusResult属性的值。
     * 
     */
    public void setHSGetUserStatusResult(int value) {
        this.hsGetUserStatusResult = value;
    }

}
