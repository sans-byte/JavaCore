package LeetOct.stack;

import java.util.Stack;

public class ParsingABooleanExpression {
    public static void main(String args[]) {
        String expression = "!(&(f,t))";
        System.out.println(parseBoolExpr(expression));
    }

    public static boolean parseBoolExpr(String expression) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            boolean hasTrue = false;
            boolean hasFalse = false;
            if (expression.charAt(i) == ')') {
                while (s.peek() != '(') {
                    char val = s.pop();
                    if (val == 'f') {
                        hasFalse = true;
                    } else if (val == 't') {
                        hasTrue = true;
                    }
                }
                s.pop(); // to pop the '('
                char op = s.pop();
                char val;
                if (op == '&') {
                    val = hasFalse ? 'f' : 't';
                    s.add(val);
                } else if (op == '|') {
                    val = hasTrue ? 't' : 'f';
                    s.add(val);
                } else if (op == '!') {
                    val = hasTrue ? 'f' : 't';
                    s.add(val);
                }
            } else {
                s.add(expression.charAt(i));
            }
        }
        System.out.println(s);
        return s.pop() == 'f' ? false : true;
    }
}
