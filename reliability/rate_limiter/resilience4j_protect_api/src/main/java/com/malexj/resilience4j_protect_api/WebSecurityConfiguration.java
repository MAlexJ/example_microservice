package com.malexj.resilience4j_protect_api;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfiguration {

  @Bean
  public FilterRegistrationBean<RequestLoggingFilter> clientAuthorizationTgInitDataRequestFilter() {
    var registrationBean = new FilterRegistrationBean<RequestLoggingFilter>();
    registrationBean.setFilter(new RequestLoggingFilter());
    return registrationBean;
  }
}
