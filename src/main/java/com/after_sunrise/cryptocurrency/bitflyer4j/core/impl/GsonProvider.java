package com.after_sunrise.cryptocurrency.bitflyer4j.core.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonParseException;
import com.google.inject.Provider;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

/**
 * @author takanori.takase
 * @version 0.0.1
 **/
@Slf4j
public class GsonProvider implements Provider<Gson> {

    private static final DateTimeFormatter DTF = ISO_LOCAL_DATE_TIME.withZone(ZoneId.of("GMT"));

    private final Map<Type, Map<String, Enum<?>>> enums = new ConcurrentHashMap<>();

    @Override
    public Gson get() {

        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(ZonedDateTime.class, (JsonDeserializer<ZonedDateTime>) (j, t, c) -> {

            if (j.isJsonNull()) {
                return null;
            }

            String value = j.getAsString();

            try {

                return ZonedDateTime.parse(value, DTF);

            } catch (DateTimeParseException e) {

                String msg = "Invalid date/time : " + value;

                throw new JsonParseException(msg, e);

            }

        });

        builder.registerTypeHierarchyAdapter(Enum.class, (JsonDeserializer<Enum<?>>) (j, t, c) -> {

            if (j.isJsonNull()) {
                return null;
            }

            String value = j.getAsString();

            value = StringUtils.replaceChars(value, ' ', '_');

            value = value.toUpperCase();

            Map<String, Enum<?>> cache = enums.computeIfAbsent(t, type -> {

                Map<String, Enum<?>> map = new LinkedHashMap<>();

                for (Object o : ((Class<?>) t).getEnumConstants()) {

                    Enum<?> element = (Enum<?>) o;

                    map.put(element.name(), element);

                }

                return map;

            });

            Enum<?> element = cache.get(value);

            if (element == null) {

                String name = ((Class<?>) t).getSimpleName();

                String raw = j.getAsString();

                log.warn("Skipping deserialization for enum {} : {}", name, raw);

            }

            return (Enum<?>) element;

        });

        return builder.create();

    }

}
