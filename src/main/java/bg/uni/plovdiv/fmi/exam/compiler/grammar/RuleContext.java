package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class RuleContext implements ParseTree {

    public ParseTree parent;
    public List<ParseTree> children;
    @Override
    public ParseTree getParent() {
        return null;
    }

    @Override
    public void setParent(ParseTree parent) {

    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public Object getPayload() {
        return null;
    }

    @Override
    public void addChild(ParseTree child) {
        child.setParent(this);
        if (this.children == null)
            this.children = new ArrayList<>();
        this.children.add(child);
    }

    @Override
    public ParseTree getChild(int i) {
        return this.children.get(i);
    }

    @Override
    public int getChildCount() {
        return children != null ? children.size() : 0;
    }

    @Override
    public String toStringTree() {
        return null;
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) {
        return null;
    }
}
