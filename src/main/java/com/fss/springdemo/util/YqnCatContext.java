package com.fss.springdemo.util;

import com.dianping.cat.Cat;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/13 20:21
 **/
public class YqnCatContext implements Cat.Context, Serializable {

    private static final long serialVersionUID = 8426007314231681410L;

    private Map<String, String> properties = new HashMap<String, String>();

    @Override
    public void addProperty(String s, String s1) {
        properties.put(s, s1);
    }

    @Override
    public String getProperty(String s) {
        return properties.get(s);
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}