
package com.rds.platform.web.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetUserInfoByLoginNameResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "getUserInfoByLoginNameResult"
})
@XmlRootElement(name = "GetUserInfoByLoginNameResponse")
public class GetUserInfoByLoginNameResponse {

    @XmlElement(name = "GetUserInfoByLoginNameResult")
    protected int getUserInfoByLoginNameResult;

    /**
     * ��ȡgetUserInfoByLoginNameResult���Ե�ֵ��
     * 
     */
    public int getGetUserInfoByLoginNameResult() {
        return getUserInfoByLoginNameResult;
    }

    /**
     * ����getUserInfoByLoginNameResult���Ե�ֵ��
     * 
     */
    public void setGetUserInfoByLoginNameResult(int value) {
        this.getUserInfoByLoginNameResult = value;
    }

}