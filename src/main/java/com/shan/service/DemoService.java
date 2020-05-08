package com.shan.service;

import javax.jws.WebService;

/**
 * @author sc
 * @createTime 2020/5/8 13:48
 * @description
 */
@WebService(
        name = "DemoService",
        targetNamespace = "http://service.shan.com"
)
public interface DemoService {


    public String sayHello(String user);

}
