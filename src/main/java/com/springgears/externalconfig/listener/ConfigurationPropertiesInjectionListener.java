package com.springgears.externalconfig.listener;

import com.springgears.externalconfig.properties.PlayerConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConfigurationPropertiesInjectionListener
        implements ApplicationListener<ContextRefreshedEvent> {

    private final PlayerConfigProperties playerConfigProperties;

    @Autowired
    public ConfigurationPropertiesInjectionListener(PlayerConfigProperties properties) {
        this.playerConfigProperties = properties;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("@ConfigurationProperties. Max track length is {} seconds",
                playerConfigProperties.getMaxTrackLength().getSeconds());
        log.info("@ConfigurationProperties. Tracks location is {}",
                playerConfigProperties.getTracksLocation());
    }
}
