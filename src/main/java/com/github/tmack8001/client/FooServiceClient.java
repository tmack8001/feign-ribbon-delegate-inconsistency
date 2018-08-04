package com.github.tmack8001.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "foo-service")
public interface FooServiceClient {

    @GetMapping(value = "/get?client=foo-service")
    void get(@RequestParam("route") String route, @RequestParam("filter") String filter);
}
