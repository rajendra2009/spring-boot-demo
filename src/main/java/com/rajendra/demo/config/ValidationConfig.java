package com.rajendra.demo.config;

import javax.validation.Validator;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * This is validation message config for Hibernate
 * 
 * This add message source to validation message source
 * 
 * @author rajendra
 *
 */
@Configuration
public class ValidationConfig {

	@Bean
	public Validator validator(MessageSource messageSource) {
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		factory.setValidationMessageSource(messageSource);
		return factory;
	}
}
