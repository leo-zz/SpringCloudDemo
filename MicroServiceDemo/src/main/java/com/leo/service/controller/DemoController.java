package com.leo.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


@RequestMapping("/test")
@RestController
public class DemoController {
    //从配置文件中读取实例名称
    @Value("${eureka.instance.instance-id}")
    String instanceID;

    @PostMapping("/hello/{name}")
    public String demoTest1(@PathVariable(value = "name") String name,
                            @RequestParam(value = "from") String user){
        return "Hello "+name+",this is DemoTest.From "+user+"@："+instanceID+".";
    }
    @PostMapping("/upload")
    public String demoTest2(@RequestParam("file") MultipartFile file){
        String str="file名称："+file.getOriginalFilename()+"，file大小："+file.getSize()+"From "+instanceID+".";
        System.out.println(str);
        return str;
    }
}
