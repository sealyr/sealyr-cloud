package com.sealyr.framework.cloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SEALYR-CLOUD-NETFLIX-EUREKA-CLIENT", fallback = HelloFeignFallback.class)
public interface HelloFeignClient {

  @GetMapping("/")
  String sayHello(@RequestParam(value = "name") String name);

}
