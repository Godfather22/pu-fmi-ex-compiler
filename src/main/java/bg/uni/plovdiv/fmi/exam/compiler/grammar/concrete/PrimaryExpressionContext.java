package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

public class PrimaryExpressionContext extends RuleContext {

    private IdentContext identContext;

    private ExpressionContext expressionContext;
    private PrimaryExpressionContext primaryExpressionContext;

    private NumberContext numberContext;
    private KeywordContext keywordContext;

    public PrimaryExpressionContext(IdentContext identContext, ExpressionContext expressionContext) {
        this.identContext = identContext;
        this.expressionContext = expressionContext;
    }

    public PrimaryExpressionContext(PrimaryExpressionContext primaryExpressionContext) {
        this.primaryExpressionContext = primaryExpressionContext;
    }

    public PrimaryExpressionContext(IdentContext identContext) {
        this.identContext = identContext;
    }

    public PrimaryExpressionContext(NumberContext numberContext) {
        this.numberContext = numberContext;
    }

    public PrimaryExpressionContext(KeywordContext keywordContext) {
        this.keywordContext = keywordContext;
    }

    public PrimaryExpressionContext(ExpressionContext expressionContext) {
        this.expressionContext = expressionContext;
    }

    public IdentContext getIdentContext() {
        return identContext;
    }

    public ExpressionContext getExpressionContext() {
        return expressionContext;
    }

    public PrimaryExpressionContext getPrimaryExpressionContext() {
        return primaryExpressionContext;
    }

    public NumberContext getNumberContext() {
        return numberContext;
    }

    public KeywordContext getKeywordContext() {
        return keywordContext;
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) {
        return visitor.visitPrimaryExpression(this);
    }
}
