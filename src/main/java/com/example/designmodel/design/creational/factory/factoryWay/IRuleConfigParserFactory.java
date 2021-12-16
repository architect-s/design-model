package com.example.designmodel.design.creational.factory.factoryWay;

import com.example.designmodel.design.creational.factory.parser.IRuleConfigParser;

/**
 * 工厂方法
 */
public interface IRuleConfigParserFactory {

    IRuleConfigParser createParser();

}
