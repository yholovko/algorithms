package main.java.basic;

import java.util.Stack;

/**
 * Dijkstra's Two - Stack Algorithm for Expression Evaluation
 */
public class DijkstraExpressionEvaluation {
    private static Stack<String> ops = new Stack<>(); //operations
    private static Stack<Double> val = new Stack<>(); //values

    public static void main(String[] args) {
        String expression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";

        for (String s : expression.split(" ")) {
            if (s.equals("(")) continue;
            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                    ops.push(s);
                    break;
                case ")":
                    switch (ops.pop()) {
                        case "+":
                            val.push(val.pop() + val.pop());
                            break;
                        case "-":
                            val.push(val.pop() - val.pop());
                            break;
                        case "*":
                            val.push(val.pop() * val.pop());
                            break;
                        case "/":
                            val.push(val.pop() / val.pop());
                            break;
                    }
                    break;
                default:
                    val.push(Double.valueOf(s));
                    break;
            }
        }

        System.out.println("Result = " + val.pop());
    }
}
