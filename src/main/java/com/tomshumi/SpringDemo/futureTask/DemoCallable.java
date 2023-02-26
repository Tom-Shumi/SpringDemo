package com.tomshumi.SpringDemo.futureTask;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class DemoCallable implements Supplier<String> {

    private final int id;

    public DemoCallable(int id) {
        this.id = id;
    }

    @SneakyThrows
    @Override
    public String get() {
        if (id == 2) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(1000);
        log.info("id: " + id);
        return "success";
    }
}
