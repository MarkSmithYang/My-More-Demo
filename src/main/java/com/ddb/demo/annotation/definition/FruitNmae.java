package com.ddb.demo.annotation.definition;

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitNmae {
	String name() default "";
}
