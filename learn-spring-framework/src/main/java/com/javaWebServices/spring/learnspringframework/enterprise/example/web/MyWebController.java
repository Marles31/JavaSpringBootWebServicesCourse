package com.javaWebServices.spring.learnspringframework.enterprise.example.web;

// import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaWebServices.spring.learnspringframework.enterprise.example.bussiness.BussinessService;

@Component
public class MyWebController {

    @Autowired
    private BussinessService bussinessService;
    
    public long returnValueFromBusinessService() {
        return bussinessService.calculateSum();
    }

}


