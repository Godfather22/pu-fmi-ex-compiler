package main.java.bg.uni.plovdiv.fmi.exam.compiler.exception;

public class SemanticAnalyzerException extends Exception {
    public SemanticAnalyzerException() {
        super();
    }

    public SemanticAnalyzerException(String message) {
        super(message);
    }

    public SemanticAnalyzerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SemanticAnalyzerException(Throwable cause) {
        super(cause);
    }
}
