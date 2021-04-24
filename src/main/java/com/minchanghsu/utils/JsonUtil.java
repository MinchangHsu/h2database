package com.minchanghsu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class JsonUtil {

    private static ObjectMapper om;

    static {
        om = new ObjectMapper()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
    }

    public static String toJsonLog(Object obj) {
        try {
            return om.writerWithDefaultPrettyPrinter()
                     .writeValueAsString(obj);
        } catch (Exception ex) {
            log.error("JsonUtil:", ex);
            return Objects.nonNull(obj) ? obj.toString() : "null";
        }
    }

    public static String toJson(Object obj) throws JsonProcessingException {
        return om.writerWithDefaultPrettyPrinter()
                 .writeValueAsString(obj);
    }

    public static Map<String, Object> readJsonAsMap(String json) throws IOException {
        return om.readValue(json, new TypeReference<Map<String, Object>>() {});
    }
}
