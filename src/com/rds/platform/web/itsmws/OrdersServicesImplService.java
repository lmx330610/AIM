package com.rds.platform.web.itsmws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.3
 * 2015-12-16T15:46:08.517+08:00
 * Generated source version: 3.1.3
 * 
 */
@WebServiceClient(name = "OrdersServicesImplService", 
                  wsdlLocation = "file:/D:/OrdersServices.xml",
                  targetNamespace = "http://www.chinawiserv.com/onecenter") 
public class OrdersServicesImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.chinawiserv.com/onecenter", "OrdersServicesImplService");
    public final static QName OrdersServicesImplPort = new QName("http://www.chinawiserv.com/onecenter", "OrdersServicesImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/OrdersServices.xml");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(OrdersServicesImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/D:/OrdersServices.xml");
        }
        WSDL_LOCATION = url;
    }

    public OrdersServicesImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public OrdersServicesImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OrdersServicesImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public OrdersServicesImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public OrdersServicesImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public OrdersServicesImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns OrdersServices
     */
    @WebEndpoint(name = "OrdersServicesImplPort")
    public OrdersServices getOrdersServicesImplPort() {
        return super.getPort(OrdersServicesImplPort, OrdersServices.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OrdersServices
     */
    @WebEndpoint(name = "OrdersServicesImplPort")
    public OrdersServices getOrdersServicesImplPort(WebServiceFeature... features) {
        return super.getPort(OrdersServicesImplPort, OrdersServices.class, features);
    }

}
