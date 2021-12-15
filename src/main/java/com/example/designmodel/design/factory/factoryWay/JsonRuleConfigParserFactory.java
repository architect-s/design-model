package com.example.designmodel.design.factory.factoryWay;

import com.example.designmodel.design.factory.parser.IRuleConfigParser;
import com.example.designmodel.design.factory.parser.JsonRuleConfigParser;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
