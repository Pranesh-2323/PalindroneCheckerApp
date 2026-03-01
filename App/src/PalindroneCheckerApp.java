import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize string:
        // 1. Remove all non-alphanumeric characters (including spaces)
        // 2. Convert to lowercase
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome = isPalindrome(normalized, 0, normalized.length() - 1);

        if (isPalindrome) {
            System.out.println("Palindrome (ignoring spaces & case).");
        } else {
            System.out.println("NOT a Palindrome (ignoring spaces & case).");
        }

        scanner.close();
    }

    // Reuse recursive logic
    public static boolean isPalindrome(String str, int start, int end) {

        if (start >= end) {
            return true;  // Base condition
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }
}