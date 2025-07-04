package com.bmc.extensions.loggingjson.testutils;

import java.lang.reflect.Field;

import com.bmc.extensions.loggingjson.runtime.config.JsonConfig;
import com.bmc.extensions.loggingjson.runtime.core.JsonFormatter;
import com.bmc.extensions.loggingjson.runtime.models.StructuredLog;

/**
 * Testing utilities.
 *
 * @author BareMetalCode
 */
public class TestUtils {

    private TestUtils() {}

    /**
     * Retrieves a {@link JsonConfig} from a {@link JsonFormatter}.
     *
     * @param formatter jsonFormatter to get config from
     *
     * @return a JsonConfig from the formatter
     */
    public static JsonConfig extractJsonConfig(final JsonFormatter formatter) {

        try {
            final Field structuredLogField = JsonFormatter.class.getDeclaredField("structuredLog");
            structuredLogField.setAccessible(true);
            final StructuredLog structuredLog = (StructuredLog) structuredLogField.get(formatter);
            return structuredLog.getJsonConfig();
        } catch (final NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Could not extract JsonConfig from JsonFormatter", e);
        }
    }

}
