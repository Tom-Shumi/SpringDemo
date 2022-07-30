package com.tomshumi.SpringDemo.controller;

import com.tomshumi.SpringDemo.service.ParallelDemoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parallelDemo")
@AllArgsConstructor
public class ParallelDemoController {

    private final ParallelDemoService parallelDemoService;

    @GetMapping
    public String parallelDemo() {
        final var result = parallelDemoService.parallelDemo();
        return result;
    }
}
