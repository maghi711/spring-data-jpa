package com.maghi711.bootsecuritydemo;

import java.util.List;
import java.util.stream.Stream;

public class StreamCheck {

    public static void main(String[] args) {
        processStrings(
                List.of("streams", "are", "cool"),
                false
        );
    }

    private static void processStrings(List<String> streams, boolean skipHeader) {
        Stream<String> stream = streams.stream();
        if (skipHeader) {
            stream.skip(1);
        } else {
            stream.skip(0);
        }
        stream.map(String::toUpperCase)
                .forEach(System.out::print);
    }
}
