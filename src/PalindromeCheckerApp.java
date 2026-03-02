import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word to check if it is a palindrome: ");
        String input = scanner.nextLine();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {

            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
}
