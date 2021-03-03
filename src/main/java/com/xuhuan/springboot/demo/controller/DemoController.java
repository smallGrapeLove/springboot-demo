package com.xuhuan.springboot.demo.controller;

import org.apache.commons.collections4.MapUtils;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huan.xu
 * @ClassName DemoController
 * @date 2021/1/4 19:40
 * @Description demo controller
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    Logger logger= Logger.getLogger(DemoController.class);
    /**
     * 测试方法1
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/demo1",method = RequestMethod.GET)
    public String demo1(ModelMap map){
        logger.info("info级别日志");
        try {
            int i=1/0;

        }catch (Exception e){
            e.printStackTrace();
            logger.info("catch:"+e.getMessage());
        }
        logger.info("要开始打印堆栈信息了");
        return "11";
    }

    public static void main(String[] args){
        String str="";
        Base64.encodeBase64String(str.getBytes());
    }

    @ResponseBody
    @RequestMapping(value = "/demo2",method = RequestMethod.POST)
    public Object demo2(@RequestBody Map map){
        System.out.println(MapUtils.getString(map,"str","1"));
        return "11";
    }

    @ResponseBody
    @RequestMapping(value = "/demo3",method = RequestMethod.GET)
    public Object demo3(ModelMap map){
        File dir=new File("C:\\Users\\Administrator\\Desktop\\国寿金石实体汇总");
        StringBuffer buffer=new StringBuffer("");
        String tables = Arrays.stream(dir.listFiles()).map(f -> {
            return "'"+f.getName().replaceAll(".xml", "")+"'";
        }).collect(Collectors.joining(","));


        return tables;
    }
}
