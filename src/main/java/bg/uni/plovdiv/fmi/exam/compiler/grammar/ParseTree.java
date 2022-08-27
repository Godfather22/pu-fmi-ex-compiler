package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar;

public interface ParseTree extends Visitable {
    ParseTree getParent();
    void setParent(ParseTree parent);
    String getText();
    Object getPayload();
    void addChild(ParseTree child);
    ParseTree getChild(int i);
    int getChildCount();
    String toStringTree();
}
