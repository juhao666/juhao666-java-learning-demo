package org.example.annotations;

import org.example.conditions.WebServiceCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional({WebServiceCondition.class})
public @interface ConditionalOnClass {

    String  value() default "";
}
