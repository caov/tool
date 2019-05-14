package com.cf.tool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: tool
 * @description: Swagger配置类
 * @author: cf
 * @create: 2019-05-09 11:13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //private static List<Parameter> webParameters = new ArrayList<Parameter>();

    /*static {
        // web
        ParameterBuilder webToken = new ParameterBuilder();
        webToken.name("accessToken").description("令牌").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        Parameter webPar = webToken.build();
        webParameters.add(webPar);
    }*/

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.cf.tool.controller"))
                .paths(PathSelectors.any())
                .build();
               // .globalOperationParameters(webParameters);
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Tool RESTful API")
                //创建人
                //.contact(new Contact().name("").email("").url(""))
                //版本号
                .version("1.0")
                //描述
                .description("API description")
                .build();
    }
}

