package it.film.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(value="Film", tags="Descrizione del progetto")
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	private  ApiInfo apiInfo() {
	   return new ApiInfoBuilder()
			.title("I pi� bei Film")
			.description("Descrizione")
			.version("1.0.0")
			.license("apache License 2.0")
			.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
			.contact(new Contact( "Jacopo", "was here", "email"))
			.build();}
		
    @Bean
    public Docket api() {
	   return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.build()
			.apiInfo(apiInfo());}
}
