package com.myapp.textfilestatistics.mapper;

import com.myapp.textfilestatistics.model.TextFileStatistics;
import com.myapp.textfilestatistics.service.TextStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TextFileStatisticsMapper {

    @Autowired
    private TextStatisticsService textStatisticsService;

    public TextFileStatistics mapToStatistics(String text) {
        int wordCount = textStatisticsService.countWords(text);
        int letterCount = textStatisticsService.countLetters(text);
        Map<Character, Integer> symbolMap = textStatisticsService.countSymbols(text);
        List<String> topWords = textStatisticsService.findTopWords(text);
        List<Character> topLetters = textStatisticsService.findTopLetters(text);

        TextFileStatistics stats=new TextFileStatistics();

        stats.setWordCount(wordCount);
        stats.setLetterCount(letterCount);
        stats.setSymbolCount(symbolMap.size());
        stats.setSymbols(symbolMap);
        stats.setTopWords(topWords);
        stats.setTopLetters(topLetters);

        return stats;
    }
}
