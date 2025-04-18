package com.bmc.extensions.loggingjson.runtime.config;

import io.quarkus.runtime.annotations.ConfigDocSection;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

import static io.quarkus.runtime.annotations.ConfigPhase.RUN_TIME;

/**
 * Configuration roots for JSON log formatting by output type.
 *
 * @author BareMetalCode
 */
@ConfigMapping(prefix = "quarkus.log")
@ConfigRoot(phase = RUN_TIME)
public interface JsonLogConfig {

    /**
     * Console logging.
     */
    @ConfigDocSection
    @WithName("console.json")
    JsonConfig consoleJson();

    /**
     * File logging.
     */
    @ConfigDocSection
    @WithName("file.json")
    JsonConfig fileJson();

}
