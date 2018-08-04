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
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author emiliano.lourbet - taitooz
 */

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


    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".html");
        return resolver;
    }
}
