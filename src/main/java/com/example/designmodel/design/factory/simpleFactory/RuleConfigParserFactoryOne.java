package com.example.designmodel.design.factory.simpleFactory;

import com.example.designmodel.design.factory.parser.*;

/**
 * 简单工厂方式一
 * 非要把if分支逻辑去掉？经典处理方法：利用多态。(工厂方法)
 */
public class RuleConfigParserFactoryOne {
    public static IRuleConfigParser createParser(String parserFormat) {
        if ("json".equals(parserFormat)) {
            return new JsonRuleConfigParser();
        } else if ("xml".equals(parserFormat)) {
            return new XmlRuleConfigParser();
        } else if ("yaml".equals(parserFormat)) {
            return new YamlRuleConfigParser();
        } else {
            return new PropertiesRuleConfigParser();
        }
    }
}
