package com.myapp.textfilestatistics.strategy;

public class LetterCountStrategy implements TextAnalysisStrategy<Integer> {

    @Override
    public Integer analyze(String text) {
        return (int) text.chars().filter(Character::isLetter).count();
    }
}
