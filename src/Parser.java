import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Parser {
    Map<Character,Character> closingCharToOpeningChar = new HashMap<>();
    {
        closingCharToOpeningChar.put('}', '{');
        closingCharToOpeningChar.put(')', '(');
    }

    public boolean isBalanced(String expression) {
        int[] depthsByOpeningChar = new int[255];
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isOpeningChar(c)) {
                stack.push(c);
                depthsByOpeningChar[c]++;
            }
            else {
                char last = stack.isEmpty() ? 0 : stack.peek();
                if (last != matchingOpeningChar(c))
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private Character matchingOpeningChar(char c) {
        return closingCharToOpeningChar.get(c);
    }

    private boolean isOpeningChar(char c) {
        return closingCharToOpeningChar.values().contains(c);
    }
}
