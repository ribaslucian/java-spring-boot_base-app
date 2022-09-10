package br.com.baseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @RestController
public class BaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(BaseApplication.class, args);
  }

  // @GetMapping("/hello")
  // public String hello(
  //   @RequestParam(value = "name", defaultValue = "World") String name
  // ) {
  //   return String.format("Hello %s!", name);
  // }
}
