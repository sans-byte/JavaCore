import java.util.*;

public class ParenthesisChecker {
    public static void main(String[] args) {
        String s = ")[]";
        System.out.println(isBalanced(s));
    }

    static boolean isBalanced(String s) {
        Set<Character> set = Set.of('[', '{', '(');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else {
                if (stack.isEmpty())
                    return false;
                if (s.charAt(i) == '}') {
                    if (stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                } else if (s.charAt(i) == ']') {
                    if (stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                } else {
                    if (stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
