package main.java.bg.uni.plovdiv.fmi.exam.compiler.analyzer.lexical;

public interface Token {
    TokenType getTokenType();
    String getTokenValue();
}
