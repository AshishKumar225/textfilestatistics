package com.myapp.textfilestatistics.service;

import com.myapp.textfilestatistics.context.TextAnalyzer;
import com.myapp.textfilestatistics.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TextStatisticsService {

    @Autowired
    private TextAnalyzer textAnalyzer;

    public int countWords(String text) {
        return textAnalyzer.analyze(text, new WordCountStrategy());
    }

    public int countLetters(String text) {
        return textAnalyzer.analyze(text, new LetterCountStrategy());
    }

    public Map<Character, Integer> countSymbols(String text) {
        return textAnalyzer.analyze(text, new SymbolCountStrategy());
    }

    public List<String> findTopWords(String text) {
        return textAnalyzer.analyze(text, new TopWordsStrategy());
    }

    public List<Character> findTopLetters(String text) {
        return textAnalyzer.analyze(text, new TopLettersStrategy());
    }
}
