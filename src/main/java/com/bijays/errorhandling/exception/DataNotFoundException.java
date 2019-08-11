package com.bijays.errorhandling.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * <p>DataNotFoundException class.</p>
 *
 * @author bijayshrestha
 * @version $Id: $Id
 */

@Getter
@Slf4j
public class DataNotFoundException extends RuntimeException{

    private ExceptionResponse exception;

    public DataNotFoundException(Class clazz, String debugMessage) {
        super(generateMessage(clazz));
        exception = ExceptionResponse.builder()
                .errorMessage(generateMessage(clazz))
                .debugMessage(debugMessage)
                .status(NOT_FOUND)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    public DataNotFoundException(Class clazz, String... searchParamsMap) {
        super(generateMessage(clazz.getSimpleName(),
                toMap(String.class, String.class, searchParamsMap)));
        exception = ExceptionResponse.builder()
                .errorMessage(generateMessage(clazz.getSimpleName(),
                        toMap(String.class, String.class, searchParamsMap)))
                .debugMessage(StringUtils.capitalize("Object returned empty or null for ")
                        + toMap(String.class, String.class, searchParamsMap))
                .status(NOT_FOUND)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    private static String generateMessage(Class clazz){
        return clazz.getSimpleName() + " was not found. ";
    }
    private static String generateMessage(String entity, Map<String, String> searchParams) {
        return StringUtils.capitalize(entity) +
                " was not found for parameters " +
                searchParams;
    }

    private static <K, V> Map<K, V> toMap(
            Class<K> keyType,
            Class<V> valueType,
            Object... entries) {
        if (entries.length % 2 == 1)
            throw new IllegalArgumentException("Invalid entries");
        Map map =  IntStream.range(0, entries.length / 2).map(i -> i * 2)
                .collect(HashMap::new,
                        (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
                        Map::putAll);
        return map ;
    }
}
