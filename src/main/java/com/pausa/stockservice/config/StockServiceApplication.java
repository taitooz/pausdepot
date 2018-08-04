package com.pausa.stockservice.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.pausa.stockservice")
@EnableScheduling
@EnableMBeanExport
@EnableCaching
@PropertySources({
        @PropertySource(value = "classpath:conf/env/environment.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "classpath:conf/env/environment-override.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "file:conf/env/environment.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "file:conf/env/environment-override.properties", ignoreResourceNotFound = true)
})
public class StockServiceApplication {

  public static void main(String[] args) {
      SpringApplication app = new SpringApplication(StockServiceApplication.class);
      app.run(args);
  }


    @Bean
    @Primary
    public ObjectMapper jacksonObjectMapper() {
        ObjectMapper jom = new ObjectMapper();
        jom.configure(MapperFeature.USE_ANNOTATIONS, true);
        jom.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        jom.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return jom;
    }

//    @Bean
//    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
//        registration.addUrlMappings("/*");
//        return registration;
//    }

//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//        return container -> {
//            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/static/401.html");
//            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/static/404.html");
//            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/static/500.html");
//            container.addErrorPages(error401Page, error404Page, error500Page);
//        };
//    }
}
