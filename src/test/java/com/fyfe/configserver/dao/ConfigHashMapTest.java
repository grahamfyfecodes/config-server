package com.fyfe.configserver.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ConfigHashMapTest {

    private final ConfigHashMap testObject = new ConfigHashMap();

    @Test
    void put() {
        testObject.put("abc", "123");
    }

    @Test
    void getEmpty() {
        String value = testObject.get("abc");
        assertNull(value);
    }

    @Test
    void putGet() {
        final String key = "abc";
        final String value = "123";

        testObject.put(key, value);

        final String retrievedValue = testObject.get(key);

        assertEquals(retrievedValue, value);
    }

    @Test
    void deleteEmpty() {
        String value = testObject.delete("abc");
        assertNull(value);
    }

    @Test
    void putDeleteGet() {
        final String key = "abc";
        final String value = "123";

        testObject.put(key, value);

        final String deleteReturn = testObject.delete(key);
        final String retrievedValue = testObject.get(key);

        assertEquals(deleteReturn, value);
        assertNull(retrievedValue);
    }
}