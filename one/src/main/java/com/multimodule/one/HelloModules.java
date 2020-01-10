package com.multimodule.one;


import com.multimodule.two.HiModules;

import java.lang.reflect.Method;

import static javax.xml.XMLConstants.XML_NS_PREFIX;

public class HelloModules {

    public static void main(String[] args) {
        System.out.println("Hello Modules!");
        System.out.println("The XML namespace prefix is: " + XML_NS_PREFIX);
        HiModules hiModules = new HiModules();
        System.out.println(hiModules.getHi());

        checkExportsDirectiveWithReflection();
    }

    private static void checkExportsDirectiveWithReflection() {
        try {
            Class c = Class.forName("com.multimodule.two.HiModules");
            Method m = c.getMethod("getHi");
            System.out.println(m.invoke(c.getDeclaredConstructor().newInstance()));
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }
}