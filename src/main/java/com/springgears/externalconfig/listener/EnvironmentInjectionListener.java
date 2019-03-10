package com.springgears.externalconfig.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnvironmentInjectionListener
        implements ApplicationListener<ContextRefreshedEvent> {

    private final Environment environment;

    @Autowired
    public EnvironmentInjectionListener(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Environment. Max track length is {} seconds",
                environment.getProperty("player.config.max-track-length"));
        log.info("Environment. Tracks location is {}",
                environment.getProperty("player.config.tracks-location"));
    }
}
