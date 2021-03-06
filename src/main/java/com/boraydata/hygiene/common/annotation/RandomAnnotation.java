package com.boraydata.hygiene.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RandomAnnotation {

    int min() default 0;

    int max();

    boolean needFloat() default false;

    int floatNumber() default 0;

}
