package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

public interface Visitable {
    <T> T accept(Visitor<? extends T> visitor);
}
