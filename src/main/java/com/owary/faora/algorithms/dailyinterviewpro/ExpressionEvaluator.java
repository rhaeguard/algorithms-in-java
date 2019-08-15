package com.owary.faora.algorithms.dailyinterviewpro;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a mathematical expression with just single digits, plus signs, negative signs, and brackets, evaluate the expression. Assume the expression is properly formed.
 *
 * Example:
 * Input: - ( 3 + ( 2 - 1 ) )
 * Output: -4
 *
 * @author Mensur Owary
 */
public class ExpressionEvaluator {

    public static void main(String[] args) {
        evaluate("14-(3-4+(2-1+8+9))+4+(1+2)");
    }

    private static void evaluate (String expr) {
        if (expr.charAt(0) == '-') {
            expr = "0"+expr;
        }
        Pattern pattern = Pattern.compile("\\([0-9-+]+\\)");
        while (true) {
            Matcher matcher = pattern.matcher(expr);
            if (matcher.find()) {
                String group = matcher.group();
                Integer integer = evaluateParenthesis(group);
                expr = matcher.replaceFirst(integer + "");
            } else {
                break;
            }
        }
        Integer integer = evaluateParenthesis(expr);
        System.out.println(integer);
    }

    private static Integer evaluateParenthesis(String expr){
        expr = expr .replace("(", "")
                    .replace(")", "");

        List<String> ops = Stream.of(expr.split("[\\d]"))
                .filter(e -> !e.trim().isEmpty())
                .collect(Collectors.toList());

        List<Integer> nums = Stream.of(expr.split("[+-]"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int i=0;

        for (String op : ops) {
            int n1 = nums.get(i);
            int n2 = nums.get(i+1);

            int t = 0;

            if (op.equals("+")) {
                t = n1 + n2;
            }
            else if (op.equals("-")) {
                t = n1 - n2;
            }
            i++;
            nums.set(i, t);
        }
        return nums.get(i);
    }

}
