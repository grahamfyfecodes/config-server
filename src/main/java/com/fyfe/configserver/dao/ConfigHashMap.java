package com.fyfe.configserver.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ConfigHashMap implements ConfigMap {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigMap.class);

    private final Map<String, String> config;

    public ConfigHashMap() {
        this.config = new HashMap<>();
    }

    @Override
    public String put(String key, String value) {
        LOGGER.info("Adding config. Key {}, Value {}", key, value);
        return config.put(key, value);
    }

    @Override
    public String get(String key) {
        String value = config.get(key);
        LOGGER.info(createLogMsgGet(key, value));
        return value;
    }

    @Override
    public String delete(String key) {
        String value = config.remove(key);
        LOGGER.info(createLogMsgDelete(key, value));
        return value;
    }

    private String createLogMsgGet(String key, String value) {
        return value == null ? "No config for key: " + key : "Key: " + key + " maps to value: " + value;
    }

    private String createLogMsgDelete(String key, String value) {
        return value == null ?
                "No config to delete for key: " + key :
                "Removed key: " + key + " maps to value: " + value;
    }
}
