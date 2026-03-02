import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a phrase to check if it is a palindrome: ");
        String input = scanner.nextLine();

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome = true;

        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The phrase \"" + input + "\" is a palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The phrase \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
}
