package com.test.restapitest.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebClientRunner implements ApplicationRunner {
    private final WebClient.Builder webClientBuilder;

    @Override
    public void run(ApplicationArguments args) {
        WebClient webClient = webClientBuilder.build();

        StopWatch stopWatch = new StopWatch();
        log.info("WebClient Test Start");
        stopWatch.start();

        Mono<String> resultFor3Sec = webClient.get()
                .uri("http://localhost:8080/delay/3", String.class)
                .retrieve()
                .bodyToMono(String.class);

        resultFor3Sec.subscribe(result -> {
            log.info("resultFor3Sec: {}", result);
            if(stopWatch.isRunning()) {
                stopWatch.stop();
            }

            log.info("result(3Sec): {}", stopWatch.getTotalTimeSeconds());
            stopWatch.start();
        });

        Mono<String> resultFor1Sec = webClient.get()
                .uri("http://localhost:8080/delay/1", String.class)
                .retrieve()
                .bodyToMono(String.class);

        resultFor1Sec.subscribe(result -> {
            log.info("resultFor1Sec: {}", result);
            if(stopWatch.isRunning()) {
                stopWatch.stop();
            }

            log.info("result(1Sec): {}", stopWatch.getTotalTimeSeconds());
            stopWatch.start();
        });

        Mono<String> resultFor5Sec = webClient.get()
                .uri("http://localhost:8080/delay/5", String.class)
                .retrieve()
                .bodyToMono(String.class);

        resultFor5Sec.subscribe(result -> {
            log.info("resultFor5Sec: {}", result);
            if(stopWatch.isRunning()) {
                stopWatch.stop();
            }

            log.info("result(5Sec): {}", stopWatch.getTotalTimeSeconds());
            stopWatch.start();
        });

        Mono<String> resultFor7Sec = webClient.get()
                .uri("http://localhost:8080/delay/7", String.class)
                .retrieve()
                .bodyToMono(String.class);


        resultFor7Sec.subscribe(result -> {
            log.info("resultFor7Sec: {}", result);
            if(stopWatch.isRunning()) {
                stopWatch.stop();
            }

            log.info("result(7Sec): {}", stopWatch.getTotalTimeSeconds());
            stopWatch.start();
        });

        Mono<String> resultFor9Sec = webClient.get()
                .uri("http://localhost:8080/delay/9", String.class)
                .retrieve()
                .bodyToMono(String.class);


        resultFor9Sec.subscribe(result -> {
            log.info("resultFor9Sec: {}", result);
            if(stopWatch.isRunning()) {
                stopWatch.stop();
            }

            log.info("result(9Sec): {}", stopWatch.getTotalTimeSeconds());
            stopWatch.start();
        });
    }
}