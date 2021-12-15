package com.example.designmodel.design.factory.factoryWay;


import com.example.designmodel.design.factory.parser.IRuleConfigParser;
import com.example.designmodel.design.factory.parser.XmlRuleConfigParser;

public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
