package org.example.task;

import java.util.ArrayList;
import java.util.Collections;
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
    public static void sortColors75(int[] nums) {
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

    //443. String Compression
    public static int compress443(String input) {
        char[] chars = input.toCharArray();
        int length = chars.length;
        int result = 1;
        for (int i = 1, count = 1, k = 0; i < length; i++) {
            if (chars[i - 1] == chars[i]) {
                count++;
            } else {
                chars[k] = chars[i - 1];
                k++;
                if (count != 1) {
                    char[] countChars = Integer.toString(count).toCharArray();
                    for (char countChar : countChars) {
                        chars[k] = countChar;
                        k++;
                    }
                }
                count = 1;
            }
            if (i == length - 1) {
                chars[k] = chars[i];
                k++;
                if (count != 1) {
                    char[] countChars = Integer.toString(count).toCharArray();
                    for (char countChar : countChars) {
                        chars[k] = countChar;
                        k++;
                    }
                }
                result = k;
            }
        }
        return result;
    }

    //989. Add to Array-Form of Integer
    public static List<Integer> addToArrayForm(int[] num, int k) {
        int[] kNum = new int[Integer.toString(k).length()];
        int i = kNum.length - 1;
        while (k > 0) {
            kNum[i] = k % 10;
            k /= 10;
            i--;
        }

        int len1 = kNum.length - 1;
        int len2 = num.length - 1;
        int[] first;
        int[] second;
        if (len1 >= len2) {
            first = kNum;
            second = num;
        } else {
            first = num;
            second = kNum;
        }
        List<Integer> result = new ArrayList<Integer>();
        int buf = 0;
        int j = 0;
        for (int a = first.length - 1, b = second.length - 1, curSum = 0; a >= 0; j++, a--, b--)
        {
            if (b >= 0) {
                curSum = buf + first[a] + second[b];
                if (curSum > 9) {
                    result.add(j, curSum %= 10);
                    buf = 1;
                } else {
                    result.add(j, curSum);
                    buf = 0;
                }
            } else {
                curSum = buf + first[a];
                if (curSum > 9) {
                    result.add(j, curSum %= 10);
                    buf = 1;
                } else {
                    result.add(j, curSum);
                    buf = 0;
                }
            }
        }
        if (buf == 1) {
            result.add(j, buf);
        }
        Collections.reverse(result);
        return result;
    }


    public static List<Integer> addToArrayForm2(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }


    //2108. Find First Palindromic String in the Array
    public static String firstPalindrome2108(String[] words) {
        boolean flag = false;
        for (String w : words) {
            char[] charW = w.toCharArray();
            for (int i = 0, j = charW.length - 1; i <= j; i++, j--) {
                if (charW[i] != charW[j]) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            if (flag) {
                return w;
            }
        }
        return "";
    }

}
