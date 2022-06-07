package com.springboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@ComponentScan default : @ComponentScan 패키지가 시작 위치가 됨.
@Configuration
@ComponentScan(
//		basePackages = "com.springboot",
//		basePackageClasses = AutoAppConfig.class,
		excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}