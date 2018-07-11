package com.sealyr.framework.cloud.netflix.hystrix;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class StoreController {

  @GetMapping("stores")
  @HystrixCommand(fallbackMethod = "defaultStores")
  public String getStores(@RequestParam(value = "name", required = false) String name) {
    Assert.hasText(name, "store name must be not null.");
    return name;
  }

  public String defaultStores(String name) {
    return "defaultStore";
  }

}
