/**
 * 
 */
package com.avinash.taskmanager.demo.common.configs;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * @author Avinash
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Autowired
	private TypeResolver typeResolver;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select()
				.apis(RequestHandlerSelectors.basePackage("com.avinash.taskmanager.demo")).build().pathMapping("/")
				.genericModelSubstitutes(ResponseEntity.class, CompletableFuture.class)
				.alternateTypeRules(newRule(
						typeResolver.resolve(DeferredResult.class,
								typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
						typeResolver.resolve(WildcardType.class)));
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("Task Manager").description("Task Manager APIs")
				.contact(new Contact("Avinash Naganahalli", null, "avi.naganahalli@gmail.com")).build();
	}
}
