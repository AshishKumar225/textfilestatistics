package com.myapp.textfilestatistics.strategy;

public interface TextAnalysisStrategy<T> {
    T analyze(String text);
}
