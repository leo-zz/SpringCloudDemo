package com.leo.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.logging.Logger;
import java.util.logging.Level;


@RequestMapping("/test")
@RestController
public class DemoController {

    Logger logger= Logger.getLogger("DemoController");
    //从配置文件中读取实例名称
    @Value("${eureka.instance.instance-id}")
    String instanceID;

    @PostMapping("/hello/{name}")
    public String sayHello(@PathVariable(value = "name") String name,
                            @RequestParam(value = "from") String user){
        String content="Hello "+name+",this is DemoTest.From "+user+"@："+instanceID+".";
        logger.log(Level.INFO,content);
        return content;
    }

    @GetMapping("/timeconsume/{length}")
    public String timeConsuming(@PathVariable(value = "length") int length){
        try {
            Thread.sleep(length);
        }catch (Exception e){
            e.printStackTrace();
        }
        String content="Successfully sleep "+length+" ms.";
        logger.log(Level.INFO,content);
        return content;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file){
        String str="file名称："+file.getOriginalFilename()+"，file大小："+file.getSize()+"From "+instanceID+".";
        logger.log(Level.INFO,str);
        return str;
    }


}
