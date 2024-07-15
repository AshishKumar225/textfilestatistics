package com.myapp.textfilestatistics.strategy;

import java.util.Arrays;

public class WordCountStrategy implements TextAnalysisStrategy<Integer> {

    @Override
    public Integer analyze(String text) {
        String[] words = text.split("\\W+");
        return (int) Arrays.stream(words).filter(word -> !word.isEmpty()).count();
    }
}
