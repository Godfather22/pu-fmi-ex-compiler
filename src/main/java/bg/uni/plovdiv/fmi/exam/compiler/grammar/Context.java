package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.analyzer.lexical.LexicalAnalyzer;

public interface Context {
    default int getPosition() {
        return LexicalAnalyzer.getIndex();
    }
}
