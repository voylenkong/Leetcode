package org.example.task;

import java.util.ArrayList;
import java.util.List;

public class Task {

    //344. Reverse String
    public static String revertString344(String inputStr) {
        char[] charsStr = inputStr.toCharArray();
        int lenOfCharStr = charsStr.length - 1;
        char buf;
        for (int j = lenOfCharStr, i = 0; j >= 0; j--, i++) {
           if (i <= j) {
               buf = charsStr[i];
               charsStr[i] = charsStr[j];
               charsStr[j] = buf;
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

}
