package org.example.task;

import java.beans.PropertyEditorSupport;

public class Recursion {

    //344. Reverse String
    public static String reverseString344_3(String inputStr) {
        if (inputStr.isEmpty()) {
            return "";
        } else {
            return reverseString344_3(inputStr.substring(1)) + inputStr.charAt(0);
        }
    }

    //342. Power of Four
    public static boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 4 != 0) {
            return false;
        }
        return isPowerOfFour(n / 4);
    }

    //231. Power of Two
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    //326. Power of Three
    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }

    //509. Fibonacci Number
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //509. Fibonacci Number
    public static int fib2(int n) {
        int result = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n >= 2) {
            int prev = 1;
            int beforePrev = 0;
            result = 1;
            for (int i = 1; i < n; i++) {
                result = beforePrev + prev;
                beforePrev = prev;
                prev = result;
            }
        }
        return result;
    }

}
