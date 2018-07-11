package com.sealyr.framework.cloud.netflix.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringCloudApplication
@RestController
public class RibbonApplication {

  public static void main(String[] args) {
    SpringApplication.run(RibbonApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Autowired
  private HelloService helloService;

  @GetMapping("/")
  @HystrixCommand(fallbackMethod = "defaultHi")
  public String hi(@RequestParam(defaultValue = "Sealyr") String name) {
    return helloService.hiService(name);
  }

  public String defaultHi(String name) {
    return "defaultHi";
  }

}
