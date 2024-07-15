package com.myapp.textfilestatistics.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopWordsStrategy implements TextAnalysisStrategy<List<String>> {

    @Override
    public List<String> analyze(String text) {
        String[] words = text.split("\\W+");
        Map<String, Long> wordCountMap = Arrays.stream(words)
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        return wordCountMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
