package com.example.designmodel.design.creational.factory.simpleFactory;

import com.example.designmodel.design.creational.factory.parser.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂方式二：parser可以复用的前提下，事先创建好缓存起来
 * <p>
 * 什么时候用工厂方法，什么时候用简单工厂模式？
 * 之所以将某个代码剥离出来，独立为函数或者类，原因是这个代码块的逻辑过于复杂，
 * 玻璃之后能让代码更加清晰，更加可读、可维护，但是代码块本身并不复杂，没必要拆分成
 * 独立的函数或者类。
 * 1、当对象的创建逻辑比较复杂，不只是简单的new一下，而是要组合其他类对象，做各种初始化
 * 操作的时候，推荐使用工厂方法模式，将复杂的创建逻辑拆分到多个工厂中，让每个工厂类
 * 不至于过于复杂。2、除此之外，如果对象不可服用，那么工厂类每次都要返回不同的对象，如果
 * 我们使用简单工厂模式来实现，就只能选择第一种包含if判断的实现方式，如果我们还想避免
 * 烦人的if-else，推荐使用工厂方法模式。
 */
public class RuleConfigParserFactoryTwo {

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (StringUtils.isBlank(configFormat)) {
            return null;
        }
        return cachedParsers.get(configFormat);
    }
}
