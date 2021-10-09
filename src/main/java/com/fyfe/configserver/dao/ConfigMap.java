package com.fyfe.configserver.dao;

public interface ConfigMap {

    String put(String key, String value);

    String get(String key);

    String delete(String key);
}
