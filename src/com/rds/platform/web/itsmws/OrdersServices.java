package com.rds.platform.web.itsmws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.3
 * 2015-12-16T15:46:08.503+08:00
 * Generated source version: 3.1.3
 * 
 */
@WebService(targetNamespace = "http://www.chinawiserv.com/onecenter", name = "OrdersServices")
@XmlSeeAlso({ObjectFactory.class})
public interface OrdersServices {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "publishWorkOrder", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.PublishWorkOrder")
    @WebMethod
    @ResponseWrapper(localName = "publishWorkOrderResponse", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.PublishWorkOrderResponse")
    public java.lang.String publishWorkOrder(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getWorkOrderAttachment", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.GetWorkOrderAttachment")
    @WebMethod
    @ResponseWrapper(localName = "getWorkOrderAttachmentResponse", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.GetWorkOrderAttachmentResponse")
    public java.lang.String getWorkOrderAttachment(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "queryWorkOrder", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.QueryWorkOrder")
    @WebMethod
    @ResponseWrapper(localName = "queryWorkOrderResponse", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.QueryWorkOrderResponse")
    public java.lang.String queryWorkOrder(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "revokeWorkOrder", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.RevokeWorkOrder")
    @WebMethod
    @ResponseWrapper(localName = "revokeWorkOrderResponse", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.RevokeWorkOrderResponse")
    public java.lang.String revokeWorkOrder(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getWorkOrderDetails", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.GetWorkOrderDetails")
    @WebMethod
    @ResponseWrapper(localName = "getWorkOrderDetailsResponse", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.GetWorkOrderDetailsResponse")
    public java.lang.String getWorkOrderDetails(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "markWorkOrder", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.MarkWorkOrder")
    @WebMethod
    @ResponseWrapper(localName = "markWorkOrderResponse", targetNamespace = "http://www.chinawiserv.com/onecenter", className = "com.rds.platform.web.itsmws.MarkWorkOrderResponse")
    public java.lang.String markWorkOrder(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}