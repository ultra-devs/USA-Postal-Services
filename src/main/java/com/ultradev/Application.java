package com.ultradev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.ultradev.config.ServiceInterceptor;
import com.ultradev.service.FeedFileDataParsingService;
@SpringBootApplication
/**
 * 
 * @author shanky
 *
 */
public class Application implements CommandLineRunner {
	@Autowired
	FeedFileDataParsingService fileParserService;
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		fileParserService.parseZipFile();
	}
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new ServiceInterceptor());
		registrationBean.addUrlPatterns("/api/*");

		return registrationBean;
	}
}