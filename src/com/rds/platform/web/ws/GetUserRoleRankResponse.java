
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
 *         &lt;element name="GetUserRoleRankResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "getUserRoleRankResult"
})
@XmlRootElement(name = "GetUserRoleRankResponse")
public class GetUserRoleRankResponse {

    @XmlElement(name = "GetUserRoleRankResult")
    protected int getUserRoleRankResult;

    /**
     * ��ȡgetUserRoleRankResult���Ե�ֵ��
     * 
     */
    public int getGetUserRoleRankResult() {
        return getUserRoleRankResult;
    }

    /**
     * ����getUserRoleRankResult���Ե�ֵ��
     * 
     */
    public void setGetUserRoleRankResult(int value) {
        this.getUserRoleRankResult = value;
    }

}