package com.springgears.externalconfig.listener;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConfigListener implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${player.config.max-track-length}")
    private Duration maxTrackLength;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Max track length is {} seconds", maxTrackLength.getSeconds());
    }
}
