package com.ex.bazel.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

  final static Logger LOGGER = LoggerFactory.getLogger(WebConfiguration.class);

  /**
   * Allowing cors for client
   *
   * @param registry - {@link CorsRegistry}
   */
  public void addCorsMappings(CorsRegistry registry) {
    LOGGER.info("adding cors mapping");
    registry.addMapping("*")
        .allowedMethods("*")
        .allowedOrigins("*");
  }

  /**
   * All resources are served from root level.
   *
   * @param registry {@link ResourceHandlerRegistry}
   */
  // @Override
  // public void addResourceHandlers(ResourceHandlerRegistry registry) {
  //   registry.addResourceHandler("/**")
  //     .addResourceLocations("/")
  //     .setCachePeriod(0);
  // }
  // @Override
  // public void addResourceHandlers(ResourceHandlerRegistry registry) {
  //   LOGGER.info("adding resource handlers");
  //   registry
  //     .addResourceHandler("/**")
  //     .addResourceLocations("/")
  //     .setCachePeriod(0)
  //     .resourceChain(true)
  //     .addResolver(new PathResourceResolver());
  // }
}