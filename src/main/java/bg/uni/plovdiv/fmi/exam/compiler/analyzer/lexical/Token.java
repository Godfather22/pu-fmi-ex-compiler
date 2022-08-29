package main.java.bg.uni.plovdiv.fmi.exam.compiler.analyzer.lexical;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.enums.TokenType;

public interface Token {
    TokenType getTokenType();
    char getTokenValue();
}
