import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args) {

          Scanner scanner = new Scanner(System.in);
          System.out.print("Enter a word to check if it is a palindrome: ");
            String input = scanner.nextLine();

            boolean isPalindrome = check(input, 0, input.length() - 1);

            if (isPalindrome) {
                System.out.println("The string \"" + input + "\" is a palindrome.");
            } else {
                System.out.println("The string \"" + input + "\" is NOT a palindrome.");
            }

            scanner.close();
        }


        private static boolean check(String s, int start, int end) {
            if (start >= end) {
                return true;
            }

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            return check(s, start + 1, end - 1);
        }
}
