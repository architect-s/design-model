package com.example.designmodel.design.factory.factoryWay;

import com.example.designmodel.design.factory.parser.IRuleConfigParser;
import com.example.designmodel.design.factory.parser.PropertiesRuleConfigParser;

public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
