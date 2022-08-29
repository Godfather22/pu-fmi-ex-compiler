package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.lexeme;

@Deprecated
public class DelimiterContext {

    private final char delimiter;

    public DelimiterContext(char delimiter) {
        this.delimiter = delimiter;
    }

    public char getDelimiter() {
        return delimiter;
    }
}
