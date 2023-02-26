package com.tomshumi.SpringDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class ParallelDemoService {

    public String parallelDemo() {
        log.info("Start parallel stream");
        final var list1 = IntStream.range(1, 10000000).boxed()
                .parallel()
                .map(x -> x + 1)
                .collect(Collectors.toList());
        log.info("Finish parallel stream");

        log.info("Start not parallel stream");
        final var list2 = IntStream.range(1, 10000000).boxed()
                .map(x -> x + 1)
                .collect(Collectors.toList());
        log.info("Finish not parallel stream");
        return "test";
    }
}
