package com.myapp.textfilestatistics.model;

import java.util.List;
import java.util.Map;

public class TextFileStatistics {

    private int wordCount;
    private int letterCount;
    private int symbolCount;
    private Map<Character, Integer> symbols;
    private List<String> topWords;
    private List<Character> topLetters;

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getLetterCount() {
        return letterCount;
    }

    public void setLetterCount(int letterCount) {
        this.letterCount = letterCount;
    }

    public int getSymbolCount() {
        return symbolCount;
    }

    public void setSymbolCount(int symbolCount) {
        this.symbolCount = symbolCount;
    }

    public Map<Character, Integer> getSymbols() {
        return symbols;
    }

    public void setSymbols(Map<Character, Integer> symbols) {
        this.symbols = symbols;
    }

    public List<String> getTopWords() {
        return topWords;
    }

    public void setTopWords(List<String> topWords) {
        this.topWords = topWords;
    }

    public List<Character> getTopLetters() {
        return topLetters;
    }

    public void setTopLetters(List<Character> topLetters) {
        this.topLetters = topLetters;
    }
}
