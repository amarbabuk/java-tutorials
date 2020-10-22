package com.ab.cache;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class RedisCacheRiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheRiApplication.class, args);
	}

	/*@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ab.cache.rest"))
				.build();
	}*/

	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI().info(new Info().title("Foobar API")
				.version(appVersion)
				.description("This is a sample Foobar server created using springdocs - a library for OpenAPI 3 with spring boot.")
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0")
						.url("https://ab.com")));
	}


}
