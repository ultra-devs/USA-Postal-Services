package com.ultradev.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
/**
 * 
 * @author shashank
 *
 */
public class SwaggerConfig {

	@Value("${application.version}")
	String applicationVersion;

	@Autowired
	Environment environment;

	public static final String DEFAULT_INCLUDE_PATTERN = "/api.*";

	public static final String DEFAULT_INCLUDE_PATTERN_API = "/api/v.*";
	private static final String TITLE = "Geographical DataBase ";
	private static final String DESCRIPTION = "Geographical Database Services for United State of America ";

	@Bean
	public Docket postsApi() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").apiInfo(apiInfo())
				.forCodeGeneration(true).genericModelSubstitutes(ResponseEntity.class)
				.ignoredParameterTypes(Pageable.class).ignoredParameterTypes(java.sql.Date.class)
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class)
				.securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.newArrayList(apiKey()))
				.useDefaultResponseMessages(false);

		docket = docket.select().paths(regex(DEFAULT_INCLUDE_PATTERN)).build();

		return docket;
	}

	public static final String AUTHORIZATION_HEADER = "Authorization";

	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");

	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder()
				.contact(new springfox.documentation.service.Contact("ultradev",
						"https://github.com/microservices-ultradev", "ultradev.nitc@gmail.com"))
				.license("Apache License, Version 2.0\r\n" + "").title(TITLE).description(DESCRIPTION)
				.version(applicationVersion).build();
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN_API)).build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
	}
}
