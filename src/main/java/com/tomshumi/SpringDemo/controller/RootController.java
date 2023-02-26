package com.tomshumi.SpringDemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class RootController {

    @GetMapping
    public String root() {
        return "Spring Demo Application";
    }
}
