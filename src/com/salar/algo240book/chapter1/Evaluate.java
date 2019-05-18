package com.salar.algo240book.chapter1;

import java.util.Scanner;
import java.util.Stack;

public class Evaluate {
    public static void interpret(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        // Page 129
        // Dijkstra's Two Stack Algorithm For Expression Evaluation
        while (scanner.hasNext()) {
            // Read token, push if operator
            String element = scanner.next();
            if (element.equals("("));
            else if (element.equals("+"))   ops.push(element);
            else if (element.equals("-"))   ops.push(element);
            else if (element.equals("*"))   ops.push(element);
            else if (element.equals("/"))   ops.push(element);
            else if (element.equals("sqrt")) ops.push(element);
            else if (element.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } // Token not operator or paren, push double value
            else {
                vals.push(Double.parseDouble(element));
            }
        }
        System.out.println(vals.pop());
    }
}
