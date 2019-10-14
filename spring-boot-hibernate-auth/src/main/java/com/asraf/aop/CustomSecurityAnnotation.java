package com.asraf.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CustomSecurityAnnotation {
    /**
     * Returns the list of security configuration attributes (e.g. USER, ADMIN).
     *
     * @return String[] The secure method attributes
     */
    public String[]value();
}