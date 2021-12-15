package com.example.designmodel.design.factory.factoryWay;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂方法：为工厂类再创建一个简单工厂，用来创建工厂类的对象，消除if...else
 */
public class IRuleConfigParserFactoryMap {

    private static Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        }
        return cachedFactories.get(type);
    }


}
