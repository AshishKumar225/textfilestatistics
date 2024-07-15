package com.myapp.textfilestatistics.strategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopLettersStrategy implements TextAnalysisStrategy<List<Character>> {

    @Override
    public List<Character> analyze(String text) {
        Map<Character, Long> letterCountMap = text.chars()
                .filter(Character::isLetter)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Character::toLowerCase, Collectors.counting()));

        return letterCountMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
