package com.nttdata.fhir.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 
 * This class, even though it doesn't appear to do anything, is required to enable spring security.
 * 
 * http://docs.spring.io/spring-security/site/docs/4.0.2.RELEASE/reference/htmlsingle/#abstractsecuritywebapplicationinitializer-with-spring-mvc
 * 
 * 
 *
 */
public class WebSecurityInitializer extends
		AbstractSecurityWebApplicationInitializer {
}