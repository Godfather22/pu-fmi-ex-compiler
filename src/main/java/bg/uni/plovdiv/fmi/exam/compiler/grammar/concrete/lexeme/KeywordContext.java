package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.lexeme;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.enums.Keyword;

public class KeywordContext {
    private final Keyword keyword;

    public KeywordContext(Keyword keyword) {
        this.keyword = keyword;
    }

    public Keyword getKeyword() {
        return keyword;
    }
}
