package com.jumpfrog.springBoot.dynamicReflect;

import com.jumpfrog.springBoot.dynamicReflect.config.ClassDefinition;
import javassist.*;

public class ClassManager {

    public static void createClass() throws Exception {
        ClassPool pool = ClassPool.getDefault();
// 1. 创建一个空类
        CtClass cc = pool.makeClass("com.rickiyang.learn.javassist.Person");

        // 2. 新增一个字段 private String name;
        // 字段名为name
        CtField param = new CtField(pool.get("java.lang.String"), "name", cc);
        // 访问级别是 private
        param.setModifiers(Modifier.PRIVATE);
        // 初始值是 "xiaoming"
        cc.addField(param, CtField.Initializer.constant("xiaoming"));

        // 3. 生成 getter、setter 方法
        cc.addMethod(CtNewMethod.setter("setName", param));
        cc.addMethod(CtNewMethod.getter("getName", param));
        // 4. 添加无参的构造函数
        CtConstructor cons = new CtConstructor(new CtClass[]{}, cc);
        cons.setBody("{name = \"xiaohong\";}");
        cc.addConstructor(cons);
    }

    public static void main(String[] args) throws Exception {
        createClass();
        ClassPool pool = ClassPool.getDefault();
        CtClass clazz = pool.get("com.rickiyang.learn.javassist.Person");
        Object person = clazz.toClass().newInstance();

        System.out.println(pool.get("com.jumpfrog.springBoot.dynamicReflect.config.ClassDefinition"));
    }

}
