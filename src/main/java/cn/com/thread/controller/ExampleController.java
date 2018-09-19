package cn.com.thread.controller;

import cn.com.thread.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController 是一个结合了 @ResponseBody 和 @Controller 的注解
@RestController
@RequestMapping("/test")
public class ExampleController {

    @Autowired
    ExampleService exampleService;

    //访问路径，post方法
    @RequestMapping(value="/getNameByClassId",method = RequestMethod.POST)
    public String getNameByClassId(@RequestParam String id){

        String name = exampleService.getNameByClassId(id);
        if("".equals(name)|| name == null){
            name = "id is error";
        }
        return name;
    }


}
