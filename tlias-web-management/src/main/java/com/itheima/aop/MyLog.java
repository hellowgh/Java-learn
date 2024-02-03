package com.itheima.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 指定注解在什么环境下生效（RetentionPolicy.RUNTIME 运行时生效）
@Target(ElementType.METHOD) // 对什么内容生效 （ElementType.METHOD 对所有方法生效）
public @interface MyLog {
}
