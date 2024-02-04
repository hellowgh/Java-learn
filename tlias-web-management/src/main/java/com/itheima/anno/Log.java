package com.itheima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 作用在类上还是方法上
@Retention(RetentionPolicy.RUNTIME) // 什么时候生效
public @interface Log {
}
