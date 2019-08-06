package com.yaoyao.controller;

import com.yaoyao.config.ValMapConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @className TestValController
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/08/02 14:42
 */
@RequestMapping("/val")
@RestController
@Slf4j
public class TestValController {
    @RequestMapping("/xml")
    public String valXml(@RequestBody String xml) {
        try {
            System.out.println(xml);
        Validator validator = readXMLSchema(String.valueOf(ValMapConfig.map.get("xml"))).newValidator();
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        validator.validate(new StreamSource(inputStream));
        } catch (SAXParseException e) {
            log.error(":报文中第"+e.getLineNumber()+"行,第"+e.getColumnNumber()+"位,错误信息:"+e.toString());
            return ":报文中第"+e.getLineNumber()+"行,第"+e.getColumnNumber()+"位,错误信息:"+e.toString();
        } catch (IOException e) {
            log.error(":"+e.getMessage());
        } catch (SAXException e) {
            log.error(":"+e.toString());
        }

        return "xx";
    }
    @RequestMapping("/xml2")
    public String valXml2(@RequestBody String xml)  {
        try {
            System.out.println(xml);
            Validator validator = readXMLSchema(String.valueOf(ValMapConfig.map.get("xml2"))).newValidator();
            InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
            validator.validate(new StreamSource(inputStream));
        } catch (SAXParseException e) {
            log.error(":报文中第"+e.getLineNumber()+"行,第"+e.getColumnNumber()+"位,错误信息:"+e.toString());
            return ":报文中第"+e.getLineNumber()+"行,第"+e.getColumnNumber()+"位,错误信息:"+e.toString();
        } catch (IOException e) {
            log.error(":"+e.getMessage());
        } catch (SAXException e) {
            log.error(":"+e.toString());
        }

        return "xx";
    }
    @RequestMapping("/addxml")
    public String addvalXml(@RequestBody String xml) throws SAXException, IOException {
        ValMapConfig.map.put("xml2",xml);
        return "xx";
    }
    /**
     * 功能描述: 读取xmlshema文件
     *
     * @auther: yaoyao
     * @date: 2019/4/3 14:56
     */
    public static Schema readXMLSchema(String xsdSchema) throws org.xml.sax.SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        //现阶段默认单个xmlSchema文件。后续需要再更改
        InputStream[] inputStreams = new InputStream[1];
        inputStreams[0] = new ByteArrayInputStream(xsdSchema.getBytes());
        Source[] sources = new Source[inputStreams.length];
        for (int i = 0; i < inputStreams.length; i++) {
            sources[i] = new StreamSource(inputStreams[i]);
        }
        Schema schema = factory.newSchema(sources);
        return schema;
    }
}
