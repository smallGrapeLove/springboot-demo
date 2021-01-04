package com.xuhuan.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huan.xu
 * @ClassName DemoController
 * @date 2021/1/4 19:40
 * @Description demo controller
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    /**
     * 测试方法1
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/demo1")
    public String demo1(ModelMap map){

        return "11";
    }
}
