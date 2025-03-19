package com.soft.technology.transactions_management;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
