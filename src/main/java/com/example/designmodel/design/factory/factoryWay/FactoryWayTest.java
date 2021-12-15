package com.example.designmodel.design.factory.factoryWay;


import com.example.designmodel.design.factory.parser.IRuleConfigParser;

public class FactoryWayTest {

    /**
     * 工厂类对象的创建逻辑有耦合进了load函数中，引入工厂方法非但没有解决问题，反倒让设计变得更加复杂了，怎么解决？
     * 为工厂类再创建一个简单工厂
     */
    public IRuleConfigParserFactory load(String ruleConfigFilePath) {
        IRuleConfigParserFactory iRuleConfigParserFactory = null;
        if ("json".equalsIgnoreCase(ruleConfigFilePath)) {
            iRuleConfigParserFactory = new JsonRuleConfigParserFactory();
        } else if ("xml".equalsIgnoreCase(ruleConfigFilePath)) {
            iRuleConfigParserFactory = new XmlRuleConfigParserFactory();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFilePath)) {
            iRuleConfigParserFactory = new YamlRuleConfigParserFactory();
        } else if ("properties".equalsIgnoreCase(ruleConfigFilePath)) {
            iRuleConfigParserFactory = new PropertiesRuleConfigParserFactory();
        } else {
            System.out.println("不支持当前格式解析");
        }
        IRuleConfigParser parser = iRuleConfigParserFactory.createParser();

        return iRuleConfigParserFactory;
    }


}
