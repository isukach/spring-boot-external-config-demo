package com.springgears.externalconfig.listener;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValueInjectionListener implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${player.config.max-track-length}")
    private Duration maxTrackLength;

    @Value("${player.config.tracks-location}")
    private String tracksLocation;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("@Value. Max track length is {} seconds", maxTrackLength.getSeconds());
        log.info("@Value. Tracks location is {}", tracksLocation);
    }
}
