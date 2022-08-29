package main.java.bg.uni.plovdiv.fmi.exam.compiler.analyzer.lexical;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.enums.TokenType;

public class ConcreteToken implements Token {

    private final TokenType type;
    private final char value;

    public ConcreteToken(TokenType type, char value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public TokenType getTokenType() {
        return type;
    }

    @Override
    public char getTokenValue() {
        return value;
    }
}
