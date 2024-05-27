package com.example.back.example;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
@Component
public class Backpressure {

    public void backpressure_drop() {
        Flux
                .interval(Duration.ofMillis(1L))
                .onBackpressureDrop(dropped -> log.info("* on dropped: {}", dropped))
                .publishOn(Schedulers.parallel())
                .subscribe(data -> {
                            processWork(5L);
                            loggedNextData(data);
                        },
                        error -> loggedError());

        processWork(2000L);
    }

    public void backpressure_error() {
        Flux
                .interval(Duration.ofMillis(1L))
                .onBackpressureError()
                .publishOn(Schedulers.parallel())
                .subscribe(data -> {
                            processWork(5L);
                            loggedNextData(data);
                        },
                        error -> loggedError());

        processWork(2000L);
    }

    public void backpressure_latest() {
        Flux
                .interval(Duration.ofMillis(1L))
                .onBackpressureLatest()
                .publishOn(Schedulers.parallel())
                .subscribe(data -> {
                            processWork(5L);
                            loggedNextData(data);
                        },
                        error -> loggedError());

        processWork(2000L);
    }

    @SneakyThrows
    private void processWork(Long t) {
        Thread.sleep(t);
    }

    private void loggedError() {
        log.error("* error EXIT");
    }

    private void loggedNextData(final Long data) {
        log.info("* next data : {}", data);
    }

}
