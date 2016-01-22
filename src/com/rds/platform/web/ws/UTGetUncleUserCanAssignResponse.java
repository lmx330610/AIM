
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
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
 *         &lt;element name="UT_GetUncleUserCanAssignResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "utGetUncleUserCanAssignResult"
})
@XmlRootElement(name = "UT_GetUncleUserCanAssignResponse")
public class UTGetUncleUserCanAssignResponse {

    @XmlElement(name = "UT_GetUncleUserCanAssignResult")
    protected UTGetUncleUserCanAssignResponse.UTGetUncleUserCanAssignResult utGetUncleUserCanAssignResult;

    /**
     * 获取utGetUncleUserCanAssignResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link UTGetUncleUserCanAssignResponse.UTGetUncleUserCanAssignResult }
     *     
     */
    public UTGetUncleUserCanAssignResponse.UTGetUncleUserCanAssignResult getUTGetUncleUserCanAssignResult() {
        return utGetUncleUserCanAssignResult;
    }

    /**
     * 设置utGetUncleUserCanAssignResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link UTGetUncleUserCanAssignResponse.UTGetUncleUserCanAssignResult }
     *     
     */
    public void setUTGetUncleUserCanAssignResult(UTGetUncleUserCanAssignResponse.UTGetUncleUserCanAssignResult value) {
        this.utGetUncleUserCanAssignResult = value;
    }


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
     *         &lt;any/>
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
        "any"
    })
    public static class UTGetUncleUserCanAssignResult {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * 获取any属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * 设置any属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
