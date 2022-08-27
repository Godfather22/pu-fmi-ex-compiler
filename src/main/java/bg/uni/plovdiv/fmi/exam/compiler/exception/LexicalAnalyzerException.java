package main.java.bg.uni.plovdiv.fmi.exam.compiler.exception;

public class LexicalAnalyzerException extends Exception {
    public LexicalAnalyzerException() {
        super();
    }

    public LexicalAnalyzerException(String message) {
        super(message);
    }

    public LexicalAnalyzerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LexicalAnalyzerException(Throwable cause) {
        super(cause);
    }
}
