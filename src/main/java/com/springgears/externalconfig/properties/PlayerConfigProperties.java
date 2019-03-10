package com.springgears.externalconfig.properties;

import java.time.Duration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "player.config")
public class PlayerConfigProperties {

    private Duration maxTrackLength;

    private String tracksLocation;
}
