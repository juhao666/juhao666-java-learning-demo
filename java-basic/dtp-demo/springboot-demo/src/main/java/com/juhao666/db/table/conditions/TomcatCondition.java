package com.juhao666.db.table.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TomcatCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //metadata 可以读取注解里面的value 去判断具体的bean 是否是我们期望的类型
        annotatedTypeMetadata.getAnnotationAttributes("value");
        try {
            conditionContext.getClassLoader().loadClass("org.apache.catalina.startup.Tomcat");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }

    }
}
