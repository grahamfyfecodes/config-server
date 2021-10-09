package com.fyfe.configserver.service;

import com.fyfe.configserver.dao.ConfigMap;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    private final ConfigMap configMap;

    public ConfigService(ConfigMap configMap) {
        this.configMap = configMap;
    }

    public String put(String key, String value) {
        String replacedValue = configMap.put(key, value);
        return createPutReturnString(key, value, replacedValue);
    }

    private String createPutReturnString(String key, String value, String replacedValue) {
        return replacedValue == null ?
                "Added Key: " + key + ", Value: " + value :
                "Added Key: " + key + ", Value: " + value + "\nReplaced: " + replacedValue;
    }

    public String get(String key) {
        String value = configMap.get(key);
        return value == null ? "No value for key: " + key : value;
    }

    public String delete(String key) {
        String value = configMap.delete(key);
        return value == null ? "No value deleted for key: " + key : "Value: " + value + " deleted for key: " + key;
    }
}
