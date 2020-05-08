package com.shan.controller;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sc
 * @createTime 2020/5/8 16:42
 * @description  调用webservice客户端
 */
@RestController
public class WebServiceClient {


    /**
     * 调用自定义WebService服务
     * @return
     */
    @GetMapping(value = "/test1")
   public String test1() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/services/DemoService?wsdl");
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            HTTPConduit conduit = (HTTPConduit) client.getConduit();
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setConnectionTimeout(2000);// 连接超时
            httpClientPolicy.setAllowChunking(false); // 取消块编码
            httpClientPolicy.setReceiveTimeout(120000); // 响应超时
            conduit.setClient(httpClientPolicy);
            objects = client.invoke("sayHello", "张三");
            return  objects[0]+"";

        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 调用三方WebService服务  查手机号归属
     * @return
     */
    @GetMapping(value = "/test2")
    public String test2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            HTTPConduit conduit = (HTTPConduit) client.getConduit();
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setConnectionTimeout(2000);// 连接超时
            httpClientPolicy.setAllowChunking(false); // 取消块编码
            httpClientPolicy.setReceiveTimeout(120000); // 响应超时
            conduit.setClient(httpClientPolicy);
            objects = objects = client.invoke("getMobileCodeInfo","15510124991","");
            System.out.println(objects[0]);
            return  objects[0]+"";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
