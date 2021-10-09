package com.fyfe.configserver.controller;

import com.fyfe.configserver.service.ConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config/")
public class HelloController {

    private final ConfigService configService;

    public HelloController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping(value = "hello")
    public String helloWorld() {
        return "World";
    }

    @GetMapping(value = "put")
    public String put(@RequestParam String key, @RequestParam String value) {
        return configService.put(key, value);
    }

    @GetMapping(value = "get")
    public String get(@RequestParam String key) {
        return configService.get(key);
    }

    @GetMapping(value = "delete")
    public String delete(@RequestParam String key) {
        return configService.delete(key);
    }
}
