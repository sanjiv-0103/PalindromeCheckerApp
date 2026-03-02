import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word to check palindrome performance: ");
        String input = scanner.nextLine();

        PalindromeStrategy[] strategies = {
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        };

        String[] strategyNames = {
                "StackStrategy",
                "DequeStrategy",
                "TwoPointerStrategy"
        };

        for (int i = 0; i < strategies.length; i++) {

            long startTime = System.nanoTime();
            boolean result = strategies[i].check(input);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.println(strategyNames[i] + ": Result = " + result
                    + ", Time = " + duration + " ns");
        }

        scanner.close();
    }
}

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);
        for (char c : input.toCharArray())
            if (c != stack.pop()) return false;
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) deque.addLast(c);
        while (deque.size() > 1)
            if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }
}

class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        int start = 0, end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

}
