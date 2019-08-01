package com.yaoyao.jsonschemapojo.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @Author: yanggl
 * @Date: 2019/3/27 16:57
 * @Version: 1.0
 * @Description: TODO
 */
public class JaxbUtil {
    /**
     * JavaBean转换成xml，（UTF-8）
     *
     * @param object 需要转换的对象
     * @return xml格式字符串
     */
    public static String beanToXml(Object object) throws JAXBException {
        return beanToXml(object, "UTF-8");
    }
    /**
     * JavaBean转换成xml
     * @param object 需要转换的对象
     * @param encoding 使用指定的编码方式
     * @return xml格式字符串
     */
    public static String beanToXml(Object object, String encoding) throws JAXBException {
        if (object == null || encoding == null){
            return null;
        }
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
        StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
    }
    /**
     * xml转换成JavaBean
     * @param xmlStr 需要转换的xml字符串
     * @param tClass 需要转换成的对象的类对象
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToBean(String xmlStr, Class<T> tClass) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(xmlStr));

    }
}
