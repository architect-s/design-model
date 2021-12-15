package com.example.designmodel.design.factory.simpleFactory;

import com.example.designmodel.design.factory.parser.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂方式二：parser可以复用的前提下，事先创建好缓存起来
 */
public class RuleConfigParserFactoryTwo {

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (StringUtils.isBlank(configFormat)) {
            return null;
        }
        return cachedParsers.get(configFormat);
    }
}
