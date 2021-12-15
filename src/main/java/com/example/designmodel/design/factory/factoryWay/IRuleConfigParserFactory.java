package com.example.designmodel.design.factory.factoryWay;

import com.example.designmodel.design.factory.parser.IRuleConfigParser;

/**
 * 工厂方法
 */
public interface IRuleConfigParserFactory {

    IRuleConfigParser createParser();

}
