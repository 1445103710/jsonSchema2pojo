package com.yaoyao.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @className ValMapConfig
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/08/02 14:43
 */
public class ValMapConfig {

    public static Map map = new HashMap<>();

    static {
        map.put("yaoyao","123");
    }

    public static void setSc(String name,String value){
        map.put(name,value);
    }
}
