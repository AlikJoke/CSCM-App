package ru.project.cscm.auth.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ru.project.cscm.ws_base.filters.OptionsCorsFilter;
import ru.project.cscm.ws_base.utils.Sha512Encoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.IGNORED_ORDER)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private OptionsCorsFilter corsFilter;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
				.addFilterAfter(usernamePasswordAuthenticationFilter(), OptionsCorsFilter.class).csrf().disable()
				.authorizeRequests().antMatchers("/login", "/login/**").permitAll().and().formLogin()
				.loginPage("/login").failureUrl("/login?error").usernameParameter("username").permitAll().and().logout()
				.logoutUrl("/logout").deleteCookies("JSESSIONID", "remember-me").logoutSuccessUrl("/")
				.permitAll();
		;
	}

	@Bean
	public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() throws Exception {
		final UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
		filter.setAuthenticationManager(this.authenticationManagerBean());
		
		return filter;
	}
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return authenticationManager;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new Sha512Encoder());
	}
}