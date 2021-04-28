package com.example.servingwebcontent;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {
    private String expression;
    private String result;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
        calculateResult();
    }

    public String getResult() {
        return result;
    }

    public void calculateResult() {
        if (expression.length() == 0) {
            result = "";
            return;
        }

        String validNumberRegex = "\\-?[0-9]+(\\.[0-9])?[0-9]*";
        String operatorRegex = "[\\+\\-\\*\\/]";
        Pattern initalPattern = Pattern.compile("^" + validNumberRegex);
        Pattern continuationPattern = Pattern.compile(operatorRegex + validNumberRegex);

        Matcher m1 = initalPattern.matcher(expression);
        if (!m1.find()) {
            result = "Invalid expression!";
            return;
        }
        double expressionResult = Double.parseDouble(m1.group());
        int offset = m1.end();
        Matcher m2 = continuationPattern.matcher(expression);

        while (m2.find(offset)) {
            if (m2.start() != offset) {
                result = "Invalid expression!";
                return;
            }
            offset = m2.end();
            char operator = m2.group().charAt(0);
            switch (operator) {
                case '+':
                    expressionResult += Double.parseDouble(m2.group().substring(1));
                    break;
                case '-':
                    expressionResult -= Double.parseDouble(m2.group().substring(1));
                    break;
                case '*':
                    expressionResult *= Double.parseDouble(m2.group().substring(1));
                    break;
                case '/':
                    double number = Double.parseDouble(m2.group().substring(1));
                    if (number == 0) {
                        result = "Division by zero!";
                        return;
                    }
                    expressionResult /= number; 
                    break;
                default:
                    break;
            }
        }
        if (offset != expression.length()) {
            result = "Invalid expression!";
            return;
        }
        result = Double.toString(expressionResult);
    }
}

