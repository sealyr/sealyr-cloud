package com.sealyr.framework.cloud.openfeign;

import org.springframework.stereotype.Component;

@Component
public class HelloFeignFallback implements HelloFeignClient {

  @Override
  public String sayHello(String name) {
    return "Sorry " + name;
  }

}
