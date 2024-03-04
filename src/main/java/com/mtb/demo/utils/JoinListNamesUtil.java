package com.mtb.demo.utils;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JoinListNamesUtil {
    public static <T> String joinListNamesOf(Collection<T> list, Function<T, String> mapper) {
        if (list.isEmpty()) {
            return "";
        }
        return list.stream()
                .map(mapper)
                .collect(Collectors.joining(", "));
    }
}
