package com.example.designmodel.design.creational.factory.factoryWay;

import com.example.designmodel.design.creational.factory.parser.IRuleConfigParser;
import com.example.designmodel.design.creational.factory.parser.JsonRuleConfigParser;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
