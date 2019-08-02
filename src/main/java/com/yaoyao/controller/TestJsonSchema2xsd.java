package com.yaoyao.controller;

import com.yaoyao.jsons2xsd.Config;
import com.yaoyao.jsons2xsd.Jsons2Xsd;
import com.yaoyao.jsons2xsd.XmlUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import java.io.IOException;

/**
 * @className TestJsonSchema2xsd
 * @description: jsonSchema转化xsd文件
 * @author: yaoyao
 * @create: 2019/08/02 10:49
 */
@RestController
@RequestMapping("/xsd")
public class TestJsonSchema2xsd {

    @RequestMapping("/j2x")
    public String j2x(@RequestBody String json){
        try {
            final Config cfg = new Config.Builder()
                .createRootElement(true)
                .targetNamespace("http://www.w3.org/2001/XMLSchema")
                .nsAlias("xs")
                .name("Example2")
                .validateXsdSchema(true)
                .build();
            final Document doc = Jsons2Xsd.convert(json, cfg);
            System.out.println(doc);
            System.out.println(XmlUtil.asXmlString(doc.getDocumentElement()));
            return XmlUtil.asXmlString(doc.getDocumentElement());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
