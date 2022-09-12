package br.com.baseapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @RestController
public class BaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(BaseApplication.class, args);
  }

  @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

  // @GetMapping("/hello")
  // public String hello(
  //   @RequestParam(value = "name", defaultValue = "World") String name
  // ) {
  //   return String.format("Hello %s!", name);
  // }
}
