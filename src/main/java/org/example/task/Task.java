package org.example.task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Task {

    //344. Reverse String
    public static String reverseString344(String inputStr) {
        char[] charsStr = inputStr.toCharArray();
        int lenOfCharStr = charsStr.length - 1;
        char buf;
        for (int j = lenOfCharStr, i = 0; i <= j; j--, i++) {
            buf = charsStr[i];
            charsStr[i] = charsStr[j];
            charsStr[j] = buf;
        }
        return new String(charsStr);
    }

    //541. Reverse String II
    public static String reverseStr541(String s, int k) {
        if (k > s.length()) {
            k = s.length();
        }
        char[] charsStr = s.toCharArray();
        int lenOfCharStr = charsStr.length;
        char buf;

        int startPosition = 0;
        int endPosition = k - 1;

        while (startPosition < lenOfCharStr) {
            for (int j = endPosition, i = startPosition; i <= j; j--, i++) {
                buf = charsStr[i];
                charsStr[i] = charsStr[j];
                charsStr[j] = buf;
            }
            startPosition = endPosition + 1 + k;
            endPosition = endPosition + 2 * k;
            if (endPosition > lenOfCharStr) {
                endPosition = lenOfCharStr - 1;
            }
        }
        return new String(charsStr);
    }

    //704. Binary Search
    public static int search704(int[] nums, int target) {
        int lp = 0;
        int rp = nums.length - 1;
        int mp = rp;
        while (lp <= rp) {
            if (target == nums[lp]) {
                return lp;
            }
            if (target == nums[rp]) {
                return rp;
            }
            mp = lp + (rp - lp)/2;
            if (target == nums[mp]) {
                return mp;
            }
            if (target > nums[mp]) {
                lp = mp + 1;
            }
            if (target < nums[mp]) {
                rp = mp - 1;
            }
        }
        return -1;
    }

    //412. Fizz Buzz
    public static List<String> fizzBuzz412(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    //876. Middle of the Linked List
    public static int middleNode876(List<Integer> head) {
        int counter = 0;
        Iterator<Integer> iterator = head.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            counter++;
        }
        return counter/2;
    }

    //Bubble sort
    public static int[] bubbleSort(int[] nums) {
        int length = nums.length - 1;
        int swap = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = swap;
                }
            }

        }
        return nums;
    }

    //75. Sort Colors
    public void sortColors75(int[] nums) {
        int length = nums.length - 1;
        int swap = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = swap;
                }
            }
        }
    }

}
