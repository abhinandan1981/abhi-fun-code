package com.abhi;

/**
 * Created by Abhinandan on 05-03-2015.
 * Uses functional programming
 */
public class KeithNumber {
    /**
     * Generates expression from the input String
     * @param number
     * @return generated String
     */
    public static String expressionGenerator(String number) {
        return expressionGeneratorHelper("",number);
    }

    // Uses tail recursion
    private static String expressionGeneratorHelper(String generatedExpression, String number) {
        if(number.length() == 1) return (generatedExpression + number);
        return expressionGeneratorHelper((generatedExpression + number.charAt(0) + "+"),number.substring(1));
    }

    /**
     * Generates the new expression in But First manner :- e.g "1+2", 3 will yield "2+3" removing 1 which comes first
     * @param expr
     * @param number
     * @return newly generate expression
     */
    public static String expressionAdder(String expr, int number) {
        String inputString = String.valueOf(number);
        return expr.substring(expr.indexOf("+") + 1) + "+" + inputString;
    }

    /**
     * Generates the sum of the String expression :- "1+2" will yield 3
     * @param expr
     * @return Sum of the String expression
     */
    public static int expressionSum(String expr) {
        return expressionSumHelper(0,expr);
    }

    //Uses tail recursion
    private static int expressionSumHelper(int sum, String expr) {
        if(!expr.contains("+")) return (sum + Integer.parseInt(expr));
        String firstNumberFromExpr = expr.substring(0, expr.indexOf("+"));
        return expressionSumHelper((sum + Integer.parseInt(firstNumberFromExpr)),(expr.substring(expr.indexOf("+") + 1)));
    }

    /**
     * The public function which evaluates if the number is Keith or not
     * @param number
     * @return boolean if the number is Keith
     */
    public static boolean isKeithNumber(int number) {
        String numberStr = String.valueOf(number);
        String generateExpression = expressionGenerator(numberStr);
        return isKeithNumberHelper(generateExpression, number);
    }


    /**
     * Helper function (tail recursive) which does the function orchestration
     * @param newExpression
     * @param number
     * @return boolean if the number is Keith integer
     */
    private static boolean isKeithNumberHelper(String newExpression, int number) {

        int expressionSum = expressionSum(newExpression);
        if(expressionSum == number) {
            System.out.println("Expressions are :: " + newExpression + "=" + expressionSum);
            return true;
        }
        if(expressionSum > number) {
            System.out.println("Expressions are :: " + newExpression + "=" + expressionSum);
            return false;
        }
        System.out.println("Expressions are :: " + newExpression + "=" + expressionSum);
        return isKeithNumberHelper(expressionAdder(newExpression,expressionSum), number);

    }
}
