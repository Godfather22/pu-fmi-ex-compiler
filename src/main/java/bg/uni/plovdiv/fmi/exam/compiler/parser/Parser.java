package main.java.bg.uni.plovdiv.fmi.exam.compiler.parser;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.analyzer.lexical.LexicalAnalyzer;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.TerminalNode;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.*;

public class Parser {
    private final LexicalAnalyzer lexicalAnalyzer;

    public Parser(LexicalAnalyzer lexicalAnalyzer) {
        this.lexicalAnalyzer = lexicalAnalyzer;
    }

    public ProgramContext parseProgram() {
        return null;
    }

    public StatementContext parseStatement() {
        return null;
    }

    public ExpressionContext parseExpression() {
        return null;
    }

    public BitwiseAndExpressionContext parseBitwiseAndExpression() {
        return null;
    }

    public AdditiveExpressionContext parseAdditiveExpression() {
        return null;
    }

    public MultiplicativeExpressionContext parseMultiplicativeExpression() {
        return null;
    }

    public PrimaryExpressionContext parsePrimaryExpression() {
        return null;
    }

    public KeywordContext parseKeyword() {
        return null;
    }

    public TerminalNode parseTerminalNode() {
        return null;
    }

}
