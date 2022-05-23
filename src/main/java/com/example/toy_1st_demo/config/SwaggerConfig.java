package com.example.toy_1st_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String API_NAME = "ToyProject API";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION = "ToyProject API 명세서";

    //    swagger 접속 링크
    //    http://localhost:8080/swagger-ui/index.html

    //1. controller class 에 달아주세요
    //@Api(tags = {"1. Book_책api"}) // Swagger # 1. Book

    //2. 각 api 에 mapping있는 부분에 달아주세요
    //@ApiOperation(value = "카테고리별 책 pageable조회", notes = "카테고리별 책을 page로 조회합니다.")
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {  // API의 이름, 현재 버전, API에 대한 정보
        return new ApiInfoBuilder()
                .title(API_NAME)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .build();
    }

}
