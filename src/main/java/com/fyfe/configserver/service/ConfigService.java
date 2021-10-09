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
        return configMap.put(key, value);
    }

    public String get(String key) {
        return configMap.get(key);
    }

    public String delete(String key) {
        return configMap.delete(key);
    }
}
