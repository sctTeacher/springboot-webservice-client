package com.shan.service.impl;

import com.shan.service.DemoService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.Date;

/**
 * @author sc
 * @createTime 2020/5/8 13:49
 * @description
 */
@WebService(
        name = "DemoService",
        targetNamespace = "http://service.shan.com",
        endpointInterface = "com.shan.service.DemoService"
)
@Component
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String user) {
        return user+"，现在时间："+"("+new Date()+")";
    }
}
