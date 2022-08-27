package main.java.bg.uni.plovdiv.fmi.exam.compiler.analyzer.semantic;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.enums.SpecialSymbol;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.exception.SemanticAnalyzerException;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.*;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.LanguageBasedVisitor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SemanticAnalyzer extends LanguageBasedVisitor<Void> {

    private final Map<String, String> variableMap;

    public SemanticAnalyzer() {
        super();
        this.variableMap = new HashMap<>();
    }

    @Override
    public Void visitExpression(ExpressionContext expressionContext) throws SemanticAnalyzerException {
        if (isRuleNull(expressionContext.getFirstOperand()))
            throw new SemanticAnalyzerException("First operand of Expression cannot be null");

        SpecialSymbol operator = expressionContext.getOperator();
        var secondOperand = expressionContext.getSecondOperand();

        if (isRuleNull(secondOperand) && !isSpecialSymbolNull(operator))
            throw new SemanticAnalyzerException("Operator present, but second operand missing for Expression");

        if (!isRuleNull(secondOperand) && isSpecialSymbolNull(operator))
            throw new SemanticAnalyzerException("Missing operator for Expression with two operands");

        return super.visitExpression(expressionContext);

    }

    @Override
    public Void visitBitwiseAndExpression(BitwiseAndExpressionContext bitwiseAndExpressionContext) throws SemanticAnalyzerException {
        if (isRuleNull(bitwiseAndExpressionContext.getFirstOperand()))
            throw new SemanticAnalyzerException("First operand of BitwiseAndExpression cannot be null");

        SpecialSymbol operator = bitwiseAndExpressionContext.getOperator();
        var secondOperand = bitwiseAndExpressionContext.getSecondOperand();

        if (isRuleNull(secondOperand) && !isSpecialSymbolNull(operator))
            throw new SemanticAnalyzerException("Operator present, but second operand missing for BitwiseAndExpression");

        if (!isRuleNull(secondOperand) && isSpecialSymbolNull(operator))
            throw new SemanticAnalyzerException("Missing operator for BitwiseAndExpression with two operands");

        return super.visitBitwiseAndExpression(bitwiseAndExpressionContext);
    }

    @Override
    public Void visitAdditiveExpression(AdditiveExpressionContext additiveExpressionContext) throws SemanticAnalyzerException {
        if (isRuleNull(additiveExpressionContext.getFirstOperand()))
            throw new SemanticAnalyzerException("First operand of BitwiseAndExpression cannot be null");

        SpecialSymbol operator = additiveExpressionContext.getOperator();
        var secondOperand = additiveExpressionContext.getSecondOperand();

        if (isRuleNull(secondOperand) && !isSpecialSymbolNull(operator))
            throw new SemanticAnalyzerException("Operator present, but second operand missing for BitwiseAndExpression");

        if (!isRuleNull(secondOperand) && isSpecialSymbolNull(operator))
            throw new SemanticAnalyzerException("Missing operator for BitwiseAndExpression with two operands");

        return super.visitAdditiveExpression(additiveExpressionContext);
    }

    @Override
    public Void visitMultiplicativeExpression(MultiplicativeExpressionContext multiplicativeExpressionContext) throws SemanticAnalyzerException {
        if (isRuleNull(multiplicativeExpressionContext.getFirstOperand()))
            throw new SemanticAnalyzerException("First operand of BitwiseAndExpression cannot be null");

        SpecialSymbol operator = multiplicativeExpressionContext.getOperator();
        var secondOperand = multiplicativeExpressionContext.getSecondOperand();

        if (isRuleNull(secondOperand) && !isSpecialSymbolNull(operator))
            throw new SemanticAnalyzerException("Operator present, but second operand missing for BitwiseAndExpression");

        if (!isRuleNull(secondOperand) && isSpecialSymbolNull(operator))
            throw new SemanticAnalyzerException("Missing operator for BitwiseAndExpression with two operands");

        return super.visitMultiplicativeExpression(multiplicativeExpressionContext);
    }

    @Override
    public Void visitPrimaryExpression(PrimaryExpressionContext primaryExpressionContext) throws SemanticAnalyzerException {

        var identifier = primaryExpressionContext.getIdentContext();    // case 1, 3, 4, 5, 6
        var expression = primaryExpressionContext.getExpressionContext();   // cases 1 and 10
        var primaryExpression = primaryExpressionContext.getPrimaryExpressionContext();     // case 2
        var number = primaryExpressionContext.getNumberContext();   // case 7
        var keyword = primaryExpressionContext.getKeywordContext();     // cases 8 and 9

        var binaryOperator = primaryExpressionContext.getBinaryOperator();
        var prefixedUnaryOperator = primaryExpressionContext.getUnaryPrefixedOperator();
        var postfixedUnaryOperator = primaryExpressionContext.getUnaryPostfixedOperator();

        var openingBrace = primaryExpressionContext.getOpeningBrace();
        var closingBrace = primaryExpressionContext.getClosingBrace();

        final boolean[][] masks = {
                {true, false, false, false, false, false, false, false, false, false},      // case 1A
                {true, true, false, false, false, true, false, false, false, false},        // case 1B
                {false, false, true, false, false, false, true, false, false, false},       // case 2
                {true, false, false, false, false, false, true, false, false, false},       // cases 3 and 4
                {true, false, false, false, false, false, false, true, false, false},       // cases 5 and 6
                {false, false, false, true, false, false, false, false, false, false},      // case 7
                {false, false, false, false, true, false, false, false, false, false},      // cases 8 and 9
                {false, true, false, false, false, false, false, false, true, true}       // case 10
        };

        // construct mask for primaryExpressionContext parameter
        final boolean[] parameterMask = new boolean[10];
        parameterMask[0] = !isRuleNull(identifier);
        parameterMask[1] = !isRuleNull(expression);
        parameterMask[2] = !isRuleNull(primaryExpression);
        parameterMask[3] = !isRuleNull(number);
        parameterMask[4] = !isRuleNull(keyword);
        parameterMask[5] = !isSpecialSymbolNull(binaryOperator);
        parameterMask[6] = !isSpecialSymbolNull(prefixedUnaryOperator);
        parameterMask[7] = !isSpecialSymbolNull(postfixedUnaryOperator);
        parameterMask[8] = !isSpecialSymbolNull(openingBrace);
        parameterMask[9] = !isSpecialSymbolNull(closingBrace);

        var caseMaskOpt = Arrays.stream(masks).
                filter(m -> Arrays.equals(m, parameterMask))
                .findFirst();

        if (caseMaskOpt.isEmpty())
            throw new SemanticAnalyzerException("PrimaryExpressionContext internal state conformity error");
        else {      // check all cases involving special symbols - cases 1B, 2, 3, 4, 5, 6 and 10
            var caseMask = caseMaskOpt.get();

            if (Arrays.equals(caseMask, masks[1]))      // case 1B
                if (!binaryOperator.equals(SpecialSymbol.EQUALS))
                    throw new SemanticAnalyzerException(String.format("Expected special symbol to be %s ('%s') but instead was %s",
                            SpecialSymbol.EQUALS.name(), SpecialSymbol.EQUALS.getSymbol(), binaryOperator.getSymbol()));
            if (Arrays.equals(caseMask, masks[2]))      // case 2
                if (!prefixedUnaryOperator.equals(SpecialSymbol.PRIMARY_EXPRESSION_OPERATOR))
                    throw new SemanticAnalyzerException(String.format("Expected special symbol to be %s ('%s') but instead was %s",
                            SpecialSymbol.PRIMARY_EXPRESSION_OPERATOR.name(), SpecialSymbol.PRIMARY_EXPRESSION_OPERATOR.getSymbol(), prefixedUnaryOperator.getSymbol()));
            if (Arrays.equals(caseMask, masks[3]))      // cases 3 and 4
                if (!(prefixedUnaryOperator.equals(SpecialSymbol.INCREMENT_OPERATOR) || prefixedUnaryOperator.equals(SpecialSymbol.DECREMENT_OPERATOR)))
                    throw new SemanticAnalyzerException(String.format("Expected special symbol to be %s ('%s'), or %s ('%s') but instead was %s",
                            SpecialSymbol.INCREMENT_OPERATOR.name(), SpecialSymbol.INCREMENT_OPERATOR.getSymbol(),
                            SpecialSymbol.DECREMENT_OPERATOR.name(), SpecialSymbol.DECREMENT_OPERATOR.getSymbol(),
                            prefixedUnaryOperator.getSymbol()));
            if (Arrays.equals(caseMask, masks[4]))      // cases 5 and 6
                if (!(postfixedUnaryOperator.equals(SpecialSymbol.INCREMENT_OPERATOR) || postfixedUnaryOperator.equals(SpecialSymbol.DECREMENT_OPERATOR)))
                    throw new SemanticAnalyzerException(String.format("Expected special symbol to be %s ('%s'), or %s ('%s') but instead was %s",
                            SpecialSymbol.INCREMENT_OPERATOR.name(), SpecialSymbol.INCREMENT_OPERATOR.getSymbol(),
                            SpecialSymbol.DECREMENT_OPERATOR.name(), SpecialSymbol.DECREMENT_OPERATOR.getSymbol(),
                            postfixedUnaryOperator.getSymbol()));
            if (Arrays.equals(caseMask, masks[7]))      // case 10
                if (!(openingBrace.equals(SpecialSymbol.OPENING_BRACE) && closingBrace.equals(SpecialSymbol.CLOSING_BRACE)))
                    throw new SemanticAnalyzerException(String.format("Expected opening '%s' and closing '%s' braces but instead got '%s' and '%s'",
                            SpecialSymbol.OPENING_BRACE.getSymbol(), SpecialSymbol.CLOSING_BRACE.getSymbol(),
                            openingBrace.getSymbol(), closingBrace.getSymbol()));
        }
        return super.visitPrimaryExpression(primaryExpressionContext);
    }

    private boolean isRuleNull(RuleContext ruleContext) {
        return ruleContext == null;
    }

    private boolean areRulesNull(RuleContext... ruleContexts) {
        for (var rc : ruleContexts)
            if (rc != null)
                return false;
        return true;
    }

    private boolean isSpecialSymbolNull(SpecialSymbol specialSymbol) {
        return specialSymbol == null;
    }

    private boolean areSpecialSymbolsNull(SpecialSymbol... specialSymbols) {
        for (var ss : specialSymbols)
            if (ss != null)
                return false;
        return true;
    }

}
