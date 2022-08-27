package main.java.bg.uni.plovdiv.fmi.exam.compiler.analyzer.lexical;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.exception.LexicalAnalyzerException;

import java.util.Arrays;

public class LexicalAnalyzer {

    private final String code;
    private final int codeLength;
    private int index;
    private Token currentToken;
    private Token previousToken;

    public LexicalAnalyzer(String code) {
        this.code = code;
        this.index = 0;
        this.codeLength = code.length();
    }

    /**
     *
     * Присвоява на currentToken следващият валиден Token, ако има такъв.
     *
     * @return true, ако има валиден следващ Token.
     */
    public boolean nextToken() throws LexicalAnalyzerException {
        // докато все още има неанализиран код
        while (!isEOC()) {
            previousToken = currentToken;
            char currChar = code.charAt(index);

            // главната функция на лексикалния анализатор;
            // проверява символите от азбуката на езика
            if (Character.isLetter(currChar)) {
                // TODO letter case
            }
            else if (Character.isDigit(currChar)) {
                // TODO set currentToken to be a new Token of TokenType Digit
            }
            else if (characterIsWhitespace(currChar)) {
                skipWS();
                continue;
            }
            else {
                throw new LexicalAnalyzerException("Undefined Token.");
            }
            return true;
        }
        return false;
    }

    /**
     * EOC - End of Code; Проверява дали index е достигнал края на code.
     *
     * @return true, ако index е достигнал края на code.
     */
    private boolean isEOC() {
        return index >= codeLength;
    }

    /**
     * Помощна функция, която връща true, ако подаденият параметър е интервален символ
     * @param ch символът, който ще се проверява
     * @return true, ако подаденият параметър е интервален символ
     */
    private boolean characterIsWhitespace(Character ch) {
        return Arrays.asList(' ', '\r', '\t', '\n').contains(ch);
    }

    /**
     * WS - White Space; Пропуска празните символи ' ', '\r', '\t', '\n'.
     */
    private void skipWS() {
        while (!isEOC()) {
            if (Arrays.asList(' ', '\r', '\t', '\n').contains(code.charAt(index))) {
                index++;
            } else {
                break;
            }
        }
    }

}
