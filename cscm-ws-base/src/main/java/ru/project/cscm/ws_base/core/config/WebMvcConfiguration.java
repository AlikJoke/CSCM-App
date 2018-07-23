package ru.project.cscm.ws_base.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ru.project.cscm.ws_base.interceptors.RequestInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan
@EnableAutoConfiguration
@PropertySource(value = { "classpath:application.properties" })
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Autowired
	private RequestInterceptor requestInterceptor;

	@Value("${allowedOrigins}")
	private String allowedOrigins;

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor);
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("POST", "GET", "PUT", "OPTIONS")
				.allowedOrigins(
						StringUtils.tokenizeToStringArray(allowedOrigins, ",;"));
		WebMvcConfigurer.super.addCorsMappings(registry);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
