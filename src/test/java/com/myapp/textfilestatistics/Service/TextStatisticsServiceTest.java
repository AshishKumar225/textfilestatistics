package com.myapp.textfilestatistics.Service;

import com.myapp.textfilestatistics.context.TextAnalyzer;
import com.myapp.textfilestatistics.service.TextStatisticsService;
import com.myapp.textfilestatistics.strategy.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

 class TextStatisticsServiceTest {

    @Mock
    private TextAnalyzer textAnalyzer;

    @InjectMocks
    private TextStatisticsService textStatisticsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCountWords() {
        String text = "Hello world";
        when(textAnalyzer.analyze(any(String.class), any(WordCountStrategy.class))).thenReturn(4);
        int wordCount = textStatisticsService.countWords(text);
        assertEquals(4, wordCount);
    }

    @Test
    void testCountLetters() {
        String text = "Hello world";
        when(textAnalyzer.analyze(any(String.class), any(LetterCountStrategy.class))).thenReturn(17);
        int letterCount = textStatisticsService.countLetters(text);
        assertEquals(17, letterCount);
    }

    @Test
    void testCountSymbols() {
        String text = "Hello! world.";
        Map<Character, Integer> symbols = new HashMap<>();
        symbols.put('!', 1);
        symbols.put('.', 1);
        when(textAnalyzer.analyze(any(String.class), any(SymbolCountStrategy.class))).thenReturn(symbols);
        Map<Character, Integer> result = textStatisticsService.countSymbols(text);
        assertEquals(symbols, result);
    }

    @Test
    void testFindTopWords() {
        String text = "Hello world";
        List<String> topWords = Arrays.asList("hello", "world");
        when(textAnalyzer.analyze(any(String.class), any(TopWordsStrategy.class))).thenReturn(topWords);
        List<String> result = textStatisticsService.findTopWords(text);
        assertEquals(topWords, result);
    }

    @Test
    void testFindTopLetters() {
        String text = "Hello world";
        List<Character> topLetters = Arrays.asList('h', 'e', 'l');
        when(textAnalyzer.analyze(any(String.class), any(TopLettersStrategy.class))).thenReturn(topLetters);
        List<Character> result = textStatisticsService.findTopLetters(text);
        assertEquals(topLetters, result);
    }
}
