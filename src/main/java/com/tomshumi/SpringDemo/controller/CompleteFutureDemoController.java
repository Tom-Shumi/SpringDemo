package com.tomshumi.SpringDemo.controller;

import com.tomshumi.SpringDemo.futureTask.DemoCallable;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/completeFutureDemo")
@AllArgsConstructor
@Slf4j
public class CompleteFutureDemoController {

    @GetMapping
    public String completeFutureDemo() {
        log.info("completeFutureDemo: start");
        final var threadPool = Executors.newFixedThreadPool(3);
        IntStream.range(1, 10)
                .forEach(i -> {
                    CompletableFuture<String> future = CompletableFuture.supplyAsync(new DemoCallable(i), threadPool);
                    future.thenRun(() -> {
                        // 処理完了後に実行する処理
                        log.info("thread end:" + i);
                    });
                });

        log.info("completeFutureDemo: end");
        return "result";
    }
}
