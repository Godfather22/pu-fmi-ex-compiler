package main.java.bg.uni.plovdiv.fmi.exam.compiler.enums;

public enum SpecialSymbol {

    EQUALS("="),
    OPENING_BRACE("("),
    CLOSING_BRACE(")"),
    SEMICOLON(";"),
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    EXPRESSION_OPERATOR("|"),
    DIVISION("/"),
    BITWISE_AND_EXPRESSION_OPERATOR("&"),
    PRIMARY_EXPRESSION_OPERATOR("~"),
    INCREMENT_OPERATOR("++"),
    DECREMENT_OPERATOR("--")
    ;

    private final String symbol;

    SpecialSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
