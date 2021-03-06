
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
 *         &lt;element name="Clue_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Levels" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "clueID",
    "levels"
})
@XmlRootElement(name = "UpdateClue501")
public class UpdateClue501 {

    @XmlElement(name = "Clue_ID")
    protected String clueID;
    @XmlElement(name = "Levels")
    protected int levels;

    /**
     * 获取clueID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClueID() {
        return clueID;
    }

    /**
     * 设置clueID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClueID(String value) {
        this.clueID = value;
    }

    /**
     * 获取levels属性的值。
     * 
     */
    public int getLevels() {
        return levels;
    }

    /**
     * 设置levels属性的值。
     * 
     */
    public void setLevels(int value) {
        this.levels = value;
    }

}
