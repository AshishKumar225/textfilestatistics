package com.myapp.textfilestatistics.mapper;

import com.myapp.textfilestatistics.model.TextFileStatistics;
import com.myapp.textfilestatistics.service.TextStatisticsService;
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
import static org.mockito.Mockito.when;

class TextFileStatisticsMapperTest {

    @Mock
    private TextStatisticsService textStatisticsService;

    @InjectMocks
    private TextFileStatisticsMapper textFileStatisticsMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMapToStatistics() {
        String text = "Hello world!";

        when(textStatisticsService.countWords(text)).thenReturn(4);
        when(textStatisticsService.countLetters(text)).thenReturn(17);
        Map<Character, Integer> symbols = new HashMap<>();
        symbols.put('!', 1);
        symbols.put('.', 1);
        when(textStatisticsService.countSymbols(text)).thenReturn(symbols);
        List<String> topWords = Arrays.asList("hello", "world");
        when(textStatisticsService.findTopWords(text)).thenReturn(topWords);
        List<Character> topLetters = Arrays.asList('h', 'e', 'l');
        when(textStatisticsService.findTopLetters(text)).thenReturn(topLetters);

        TextFileStatistics stats = textFileStatisticsMapper.mapToStatistics(text);

        assertEquals(4, stats.getWordCount());
        assertEquals(17, stats.getLetterCount());
        assertEquals(2, stats.getSymbolCount());
        assertEquals(symbols, stats.getSymbols());
        assertEquals(topWords, stats.getTopWords());
        assertEquals(topLetters, stats.getTopLetters());
    }
}
