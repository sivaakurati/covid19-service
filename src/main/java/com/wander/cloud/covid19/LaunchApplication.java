/**
 * 
 */
package com.wander.cloud.covid19;

import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author SIVA KUMAR
 */
@SpringBootApplication
@EnableSwagger2
public class LaunchApplication {

	private static final Logger log = LoggerFactory.getLogger(LaunchApplication.class);
	private Model model;

	public static void main(String[] args) {
		SpringApplication.run(LaunchApplication.class, args);
	}

	@Bean
	public Docket applicationApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		try {
			model = new MavenXpp3Reader().read(new FileReader("pom.xml"));
		} catch (IOException | XmlPullParserException e) {
			log.error("LaunchApplication.metaData() -> {}", e.getMessage());
		}
		ApiInfo apiInfo = new ApiInfo(model.getName(), model.getDescription(), model.getVersion(), "Terms of service",
				new Contact("EI Team", "https://enuminfo.com/", "enuminfo2016@gmail.com"), "Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}
}
