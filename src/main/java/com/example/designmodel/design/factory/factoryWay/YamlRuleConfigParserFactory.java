package com.example.designmodel.design.factory.factoryWay;

import com.example.designmodel.design.factory.parser.IRuleConfigParser;
import com.example.designmodel.design.factory.parser.YamlRuleConfigParser;

public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
