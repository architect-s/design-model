package com.example.designmodel.design.creational.factory.factoryWay;


import com.example.designmodel.design.creational.factory.parser.IRuleConfigParser;
import com.example.designmodel.design.creational.factory.parser.XmlRuleConfigParser;

public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
