package com.test.restapitest.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
@RequiredArgsConstructor
public class RestTemplateRunner implements ApplicationRunner {
    private final RestTemplateBuilder restTemplateBuilder;

    @Override
    public void run(ApplicationArguments args) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        StopWatch stopWatch = new StopWatch();
        log.info("RestTemplate Test Start");
        stopWatch.start();

        String resultFor1Sec = restTemplate.getForObject("http://localhost:8080/delay/1", String.class);
        log.info("resultFor1Sec: {}", resultFor1Sec);

        String resultFor3Sec = restTemplate.getForObject("http://localhost:8080/delay/3", String.class);
        log.info("resultFor3Sec: {}", resultFor3Sec);

        String resultFor5Sec = restTemplate.getForObject("http://localhost:8080/delay/5", String.class);
        log.info("resultFor5Sec: {}", resultFor5Sec);

        String resultFor7Sec = restTemplate.getForObject("http://localhost:8080/delay/7", String.class);
        log.info("resultFor7Sec: {}", resultFor7Sec);

        String resultFor9Sec = restTemplate.getForObject("http://localhost:8080/delay/9", String.class);
        log.info("resultFor9Sec: {}", resultFor9Sec);

        stopWatch.stop();
        log.info("result: {}", stopWatch.getTotalTimeSeconds());
    }
}