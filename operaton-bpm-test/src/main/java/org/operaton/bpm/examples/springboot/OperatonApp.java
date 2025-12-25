package org.operaton.bpm.examples.springboot;

import org.operaton.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.operaton.bpm.spring.boot.starter.event.PostDeployEvent;
import org.operaton.bpm.spring.boot.starter.event.PreUndeployEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication(scanBasePackages = "org.operaton.bpm.examples")
@EnableProcessApplication
public class OperatonApp {

    public static void main(String... args) {
        SpringApplication.run(OperatonApp.class, args);
    }

    @EventListener
    public void onPostDeploy(PostDeployEvent event) {
        log.info("Process engine '{}' deployed", event.getProcessEngine().getName());
    }

    @EventListener
    public void onPreUndeploy(PreUndeployEvent event) {
        log.info("Process engine '{}' undeployed", event.getProcessEngine().getName());
    }

}
