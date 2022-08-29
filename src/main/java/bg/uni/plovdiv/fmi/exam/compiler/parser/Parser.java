package main.java.bg.uni.plovdiv.fmi.exam.compiler.parser;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.analyzer.lexical.LexicalAnalyzer;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.analyzer.lexical.Token;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.enums.TokenType;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.exception.LexicalAnalyzerException;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.exception.ParserException;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.TerminalNode;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.*;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.lexeme.IdentContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.lexeme.KeywordContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.lexeme.NumberContext;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final LexicalAnalyzer lexicalAnalyzer;

    public Parser(LexicalAnalyzer lexicalAnalyzer) {
        this.lexicalAnalyzer = lexicalAnalyzer;
    }

    public ProgramContext parseProgram() throws LexicalAnalyzerException, ParserException {
        List<StatementContext> statements = new ArrayList<>();
        do {
            statements.add(parseStatement());
        } while (lexicalAnalyzer.nextToken());
        return new ProgramContext(statements);
    }

    public StatementContext parseStatement() throws LexicalAnalyzerException, ParserException {
        return null;    // TODO
    }

    public int parseNumber() throws LexicalAnalyzerException {
        StringBuilder sb = new StringBuilder(lexicalAnalyzer.getCurrentToken().getTokenValue());
        lexicalAnalyzer.nextToken();
        while (lexicalAnalyzer.getCurrentToken().getTokenType().equals(TokenType.DIGIT)) {
            sb.append(lexicalAnalyzer.getCurrentToken().getTokenValue());
        }
        return Integer.parseInt(sb.toString());
    }

    public String parseIdentifier() throws LexicalAnalyzerException {
        StringBuilder sb = new StringBuilder(lexicalAnalyzer.getCurrentToken().getTokenValue());
        lexicalAnalyzer.nextToken();
        while (!lexicalAnalyzer.getCurrentToken().getTokenType().equals(TokenType.SPACE)) {
            sb.append(lexicalAnalyzer.getCurrentToken().getTokenValue());
        }
        return sb.toString();
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

    public PrimaryExpressionContext parsePrimaryExpression() throws LexicalAnalyzerException, ParserException {
        if (lexicalAnalyzer.getCurrentToken() == null) {
            lexicalAnalyzer.nextToken();
        }

        Token token = lexicalAnalyzer.getCurrentToken();

        IdentContext identifier;
        NumberContext number;

        // TODO обхождане на всички възможни Statement-и
        switch (token.getTokenType()) {
            case LETTER -> identifier = new IdentContext(parseIdentifier());
            case DIGIT -> number = new NumberContext(parseNumber());
            case SPACE -> lexicalAnalyzer.nextToken();
            case SEMICOLON -> {
                return null; // TODO
            }
            default -> throw new ParserException("Unidentified token encountered");
        }
        return null; //TODO
    }

    public KeywordContext parseKeyword() {
        return null;
    }

    public TerminalNode parseTerminalNode() {
        return null;
    }

}
