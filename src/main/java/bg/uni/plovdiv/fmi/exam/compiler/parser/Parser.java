package main.java.bg.uni.plovdiv.fmi.exam.compiler.parser;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.analyzer.lexical.LexicalAnalyzer;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;

public class Parser {
    private final LexicalAnalyzer lexicalAnalyzer;

    public Parser(LexicalAnalyzer lexicalAnalyzer) {
        this.lexicalAnalyzer = lexicalAnalyzer;
    }

    public RuleContext parseProgram() {
        return null;
    }

    public RuleContext parseStatement() {
        return null;
    }

    // TODO add language-specific nodes

    public RuleContext parseTerminal() {
        return null;
    }

}
