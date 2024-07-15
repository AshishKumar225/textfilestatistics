package com.myapp.textfilestatistics.context;

import com.myapp.textfilestatistics.strategy.TextAnalysisStrategy;
import org.springframework.stereotype.Component;

@Component
public class TextAnalyzer {

    public <T> T analyze(String text, TextAnalysisStrategy<T> strategy) {
        return strategy.analyze(text);
    }
}
