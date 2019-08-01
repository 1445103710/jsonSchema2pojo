package com.wltt.jsonschemapojo.jsonschemapojo.annotator;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JEnumConstant;
import com.sun.codemodel.JFieldVar;
import org.apache.commons.lang3.StringUtils;
import org.jsonschema2pojo.AbstractAnnotator;
import org.jsonschema2pojo.GenerationConfig;

import javax.xml.bind.annotation.XmlElement;

/**
 * @className JAXBAnnotator
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/07/31 10:56
 */
public class JAXBAnnotator extends AbstractAnnotator {

    public JAXBAnnotator(GenerationConfig generationConfig) {
        super(generationConfig);
    }


    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
        if (StringUtils.isNotEmpty(field.name()) && !field.name().equals(propertyName)) {
            field.annotate(XmlElement.class).param("name", propertyName);
        }
        field.annotate(SerializedName.class).param("value", propertyName);
        field.annotate(Expose.class);
    }


    @Override
    public void enumConstant(JDefinedClass _enum, JEnumConstant constant, String value) {
        constant.annotate(SerializedName.class).param("value", value);
        constant.annotate(XmlElement.class).param("name", value);
    }

}
