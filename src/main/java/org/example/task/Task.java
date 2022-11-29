package org.example.task;

public class Task {

    //#344. Reverse String
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

    //#704. Binary Search
    public static int search704(int[] nums, int target) {
        int lp = 0;
        int rp = nums.length - 1;
        int cp = rp;

        while (true) {
            if (target == nums[lp]) {
                return lp;
            }
            if (target == nums[rp]) {
                return rp;
            }

            cp = (rp - lp) / 2;
            if (target < nums[cp]) {
                rp = cp;
            } else {
                lp = cp + 1;
            }
            if (cp == 0) {
                return -1;
            }
        }
    }
}
