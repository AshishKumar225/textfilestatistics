package com.myapp.textfilestatistics.strategy;

import java.util.HashMap;
import java.util.Map;

public class SymbolCountStrategy implements TextAnalysisStrategy<Map<Character, Integer>> {

    @Override
    public Map<Character, Integer> analyze(String text) {
        Map<Character, Integer> symbolMap = new HashMap<>();
        text.chars()
                .filter(ch -> !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch))
                .mapToObj(ch -> (char) ch)
                .forEach(ch -> symbolMap.put(ch, symbolMap.getOrDefault(ch, 0) + 1));
        return symbolMap;
    }
}
