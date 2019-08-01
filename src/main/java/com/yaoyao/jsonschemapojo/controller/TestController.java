package com.yaoyao.jsonschemapojo.controller;

import com.google.gson.Gson;
import com.yaoyao.jsonschemapojo.javaFile.TebieYao;
import com.yaoyao.jsonschemapojo.util.JaxbUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsonschema2pojo.AnnotationStyle;
import org.jsonschema2pojo.Jsonschema2Pojo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yaoyao
 * @Date: 2019/7/8 14:44
 * @Version: 1.0
 * @Description: TODO
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/jsonSchemaToJava")
    public String jsonSchemaToJava(){
        try {
            MyArguments arguments = new MyArguments();
            List<URL> sourceList = new ArrayList();
            sourceList.add(new File("/Users/yaoyao/IdeaProjects/github/yaoyaojsonSchema2pojo/jsonSchema/tebie_yao.jsonSchema").toURI().toURL());
            arguments.setSourcePaths(sourceList);
            arguments.setTargetDirectory(new File("/Users/yaoyao/IdeaProjects/github/yaoyaojsonSchema2pojo/javaFile"));
            arguments.setAnnotationStyle(AnnotationStyle.JAXB);
            arguments.setTargetPackage("com_yao_xx");
            arguments.setIncludeJsr303Annotations(true);
            arguments.setIncludeJsr305Annotations(true);
            arguments.setSerializable(true);
            arguments.setRemoveOldOutput(true);
            arguments.setClassNamePrefix("yaoyao");
            arguments.setClassNameSuffix("nana");
            Jsonschema2Pojo.generate(arguments);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "搞定";
    }

    @RequestMapping("/xml2json")
    public String xml(@RequestBody String content){
        try {
            TebieYao tebieYao = JaxbUtil.xmlToBean(content, TebieYao.class);
            System.out.println(tebieYao.toString());
            log.debug(tebieYao.toString());
            return new Gson().toJson(tebieYao);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "失败";
    }

    @RequestMapping("/json2xml")
    public String json(@RequestBody String content){
        try {
            TebieYao tebieYao = new Gson().fromJson(content, TebieYao.class);
            System.out.println(tebieYao.toString());
            log.debug(tebieYao.toString());
            return JaxbUtil.beanToXml(tebieYao);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "失败";
    }

    @RequestMapping("/xml2xml")
    public String xml2xml(@RequestBody String content){
        try {
            TebieYao tebieYao = JaxbUtil.xmlToBean(content, TebieYao.class);
            System.out.println(tebieYao.toString());
            log.debug(tebieYao.toString());
            return JaxbUtil.beanToXml(tebieYao);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "失败";
    }

    @RequestMapping("/json2json")
    public String json2json(@RequestBody String content){
        try {
            TebieYao tebieYao = new Gson().fromJson(content, TebieYao.class);
            System.out.println(tebieYao.toString());
            log.debug(tebieYao.toString());
            return new Gson().toJson(tebieYao);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "失败";
    }

}
