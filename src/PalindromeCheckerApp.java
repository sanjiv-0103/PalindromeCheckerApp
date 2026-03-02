import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word to check if it is a palindrome: ");
        String input = scanner.nextLine();

        System.out.println("Select strategy: 1 = Stack, 2 = Deque");
        int choice = scanner.nextInt();
        scanner.nextLine();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else if (choice == 2) {
            strategy = new DequeStrategy();
        } else {
            System.out.println("Invalid choice. Defaulting to StackStrategy.");
            strategy = new StackStrategy();
        }

        boolean isPalindrome = strategy.check(input);

        if (isPalindrome) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
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

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

}
