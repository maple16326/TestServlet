package com.accenture.JasonAnnotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
/** 
*
* @author yhcui E-mail:ychui@yahoo.cn 
* @version 创建时间：Sep 26, 2017 4:44:37 PM 
* @param
* 类说明 
*/
public @interface JsonAnnotation {
	public String name();
}
 