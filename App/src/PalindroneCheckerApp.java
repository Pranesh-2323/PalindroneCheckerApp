import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * =========================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * =========================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Demonstrates dynamic selection of palindrome
 * algorithm using Strategy Design Pattern.
 */

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy (LIFO)");
        System.out.println("2. Deque Strategy (Two-Pointer)");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        System.out.print("Input: ");
        String input = scanner.nextLine();

        boolean result = strategy.check(input);

        System.out.println("Is Palindrome? : " + result);

        scanner.close();
    }
}

/**
 * =========================================================
 * INTERFACE - PalindromeStrategy
 * =========================================================
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * =========================================================
 * CLASS - StackStrategy
 * =========================================================
 * Uses LIFO principle to validate palindrome.
 */
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

/**
 * =========================================================
 * CLASS - DequeStrategy
 * =========================================================
 * Uses front & rear comparison.
 */
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