package com.shan.config;

import com.shan.service.DemoService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author sc
 * @createTime 2020/5/8 13:57
 * @description
 */
@Configuration
public class CxfConfig {

   @Autowired
    private Bus bus;
    @Autowired
    private DemoService testService;
    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, testService);
        endpoint.publish("/DemoService");
        return endpoint;
    }



}
