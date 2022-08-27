package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

import java.util.List;

public class ProgramContext extends RuleContext {
    private final List<StatementContext> statements;

    public ProgramContext(List<StatementContext> statements) {
        this.statements = statements;

        // Добавя всеки statement като дете на това листо
        for (var st : statements)
            this.addChild(st);
    }

    public List<StatementContext> getStatements() {
        return this.statements;
    }

    public StatementContext getStatement(int i) {
        return this.statements.get(i);
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) {
        return visitor.visitProgram(this);
    }
}
