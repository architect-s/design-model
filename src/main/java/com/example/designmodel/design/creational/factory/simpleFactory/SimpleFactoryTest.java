package com.example.designmodel.design.creational.factory.simpleFactory;

import com.example.designmodel.design.creational.factory.parser.IRuleConfigParser;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        IRuleConfigParser iRuleConfigParser = RuleConfigParserFactoryOne.createParser("json");
        System.out.println(iRuleConfigParser);

        IRuleConfigParser iRuleConfigParser1 = RuleConfigParserFactoryTwo.createParser("xml");
        System.out.println(iRuleConfigParser1);
    }

}
