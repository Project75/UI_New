package com.nttdata.fhir.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityIISConfig extends WebSecurityConfigurerAdapter {
	
	// Field used for programmer logging
	private static final Logger LOG = LogManager.getLogger(WebSecurityIISConfig.class);
	    
	// Platform independent new line separator
	private static final String NEWLINE = System.getProperty("line.separator");
	
	@Autowired private Environment env;

	/*@Autowired
	@Qualifier("authFailureHandlerForm")
	private AuthFailureHandlerForm authFailureHandler;
	*/
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {

		builder.inMemoryAuthentication()
	      .withUser("admin").password("password").roles("USER");				
	}
	
	
	@Override
	 protected void configure(HttpSecurity http) throws Exception {
		 
		 
		//  http.authenticationProvider(preauthAuthProvider())                                //TODO : Uncomment once pre auth provider is available.
		 	http.csrf().disable()
		     .authorizeRequests().anyRequest().hasAnyRole("USER","ADMIN").antMatchers("/login","/login.request","/logout", "/images/**", "/static/**" ,"/css/**" ,"/js/**" , "/static/lib/**").permitAll()
		    		 .anyRequest()
		    		 .authenticated()
		    		  .and()
		    		  .formLogin()
		    		      .loginPage("/login.request")
			            .loginProcessingUrl("/login")
			            .usernameParameter("username").passwordParameter("password")
			            .defaultSuccessUrl("/")
			            .failureUrl("/login?error")
			            .permitAll()// this is to fall back when PreAuth (IIS Auth) Fails with SSO.  still allowed to log in with LDAP
			            .and().exceptionHandling().accessDeniedPage("/Access_Denied")
		    		  	.and()
				         	.headers()
			         		.frameOptions().sameOrigin();
	 }
	
	
//	 @Bean
//	 public PreAuthenticatedAuthenticationProvider preauthAuthProvider() {
//		 
//		  PreAuthenticatedAuthenticationProvider preauthAuthProvider = new PreAuthenticatedAuthenticationProvider();
//		  
//		  preauthAuthProvider.setPreAuthenticatedUserDetailsService(userDetailsServiceWrapper());
//		  return preauthAuthProvider;
//	 }

}
