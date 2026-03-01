import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class UseCase13PalindromePerformanceApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        // Normalize once for fair comparison
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // -------------------------------
        // 1. Stack Approach
        // -------------------------------
        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(normalized);
        long endStack = System.nanoTime();
        long stackTime = endStack - startStack;

        // -------------------------------
        // 2. Deque Approach
        // -------------------------------
        long startDeque = System.nanoTime();
        boolean dequeResult = dequePalindrome(normalized);
        long endDeque = System.nanoTime();
        long dequeTime = endDeque - startDeque;

        // -------------------------------
        // 3. Two Pointer (Optimal)
        // -------------------------------
        long startTwoPointer = System.nanoTime();
        boolean twoPointerResult = twoPointerPalindrome(normalized);
        long endTwoPointer = System.nanoTime();
        long twoPointerTime = endTwoPointer - startTwoPointer;

        // Display Results
        System.out.println("Input: " + input);
        System.out.println("-----------------------------------");
        System.out.println("Stack Result       : " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Deque Result       : " + dequeResult + " | Time: " + dequeTime + " ns");
        System.out.println("Two Pointer Result : " + twoPointerResult + " | Time: " + twoPointerTime + " ns");
    }

    // Stack-based approach
    public static boolean stackPalindrome(String input) {
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

    // Deque-based approach
    public static boolean dequePalindrome(String input) {
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

    // Two-pointer approach (most efficient)
    public static boolean twoPointerPalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}