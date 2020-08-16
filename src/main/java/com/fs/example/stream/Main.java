package com.fs.example.stream;

import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhaofushan
 * @date 2020/8/12 0012 19:37
 */
public class Main {
    static Stream<Integer> randomSource() {
        Random random = new Random();
        Stream<Integer> generate = Stream.generate(() -> {
            return Math.abs(random.nextInt() % 1001001);
        });
        return generate;
    }

    static Stream<Integer> certain(Integer... values) {
        return Stream.of(values);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        certain(1, 2, 3, 4, 5, 6, 7)
                .parallel()
                .unordered()
                .limit(1000_0000)
                .spliterator()
                .forEachRemaining(e -> {
                    System.out.println(e);
                });
        System.out.println(System.currentTimeMillis() - start);
    }
}
