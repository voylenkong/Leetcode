package org.example.task;

import java.util.*;

public class TaskArray {

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

    //1929. Concatenation of Array
    public static int[] getConcatenation1929(int[] nums) {
        int numLength = nums.length;
        int[] result = new int[numLength * 2];
        for (int i = 0; i < numLength; i ++) {
            result[i] = nums[i];
            result[numLength + i] = nums[i];
        }
        return result;
    }

    //Sum digits into string
    public static int sumDigits(String numStr) {
        char[] strArray = numStr.toCharArray();
        int result = 0;
        for (char elem : strArray) {
            result += Character.getNumericValue(elem);
            //result += elem - '0';
        }
        return result;
    }

    //1837. Sum of Digits in Base K
    public static int sumBase1837(int n, int k) {
        int result = 0;
        int wp = n;
        int rp = n;
        while (wp >= k) {
            rp = wp % k;
            wp /= k;
            result += rp;
        }
        result += wp;
        return result;
    }

    //1945. Sum of Digits of String After Convert
    public static int getLucky1945(String s, int k) {
        char[] sChars = s.toCharArray();
        int result = 0;
        for (char ch : sChars) {
            result += (ch - 96) % 10;
            result += (ch - 96) / 10;
        }
        int wp = result;
        while (k > 1) {
            result = 0;
            while (wp > 0) {
                result += wp % 10;
                wp /= 10;
            }
            wp = result;
            k--;
        }
        return result;
    }

    //26. Remove Duplicates from Sorted Array
    public static int removeDuplicates26(int[] nums) {
        int length = nums.length;
        int k = 0;
        int i = 1;
        while (i < length) {
            if (nums[i - 1] != nums[i]) {
                nums[k] = nums[i - 1];
                k++;
            }
            i++;
        }
        if (i == length) {
            nums[k] = nums[i -1 ];
            k++;
        }
        return k;
    }

    //1920. Build Array from Permutation
    public static int[] buildArray1920(int[] nums) {
/*        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }*/

        for (int i = 0; i < nums.length; i++) {
            nums[i] += (nums[nums[i]] & 1023) << 10;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] >>= 10;
        }
        return nums;
    }

    //387. First Unique Character in a String
    public static int firstUniqChar387(String s) {
        char[] sChar = s.toCharArray();
        var resHashMap = new HashMap<Character, Integer>();
        int count = 0;
        for (char c : sChar) {
            count = resHashMap.getOrDefault(c, 0);
            count++;
            resHashMap.put(c, count);
        }
        for (int i = 0; i < sChar.length; i++) {
            if (resHashMap.get(sChar[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    //1. Two Sum
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = numMap.get(target - nums[i]);
            } else {
                numMap.put(nums[i], i);
            }
        }
        return result;
    }

    //13. Roman to Integer
    public static int romanToInt13(String s) {
        char[] sArr = s.toCharArray();
        int length = s.length();
        int result = 0;
        char cur = sArr[0];
        char prev = '0';
        for (int i = 0; i < length; i++) {
            switch (sArr[i]) {
                case 'M' -> result += 1000;
                case 'D' -> result += 500;
                case 'C' -> result += 100;
                case 'L' -> result += 50;
                case 'X' -> result += 10;
                case 'V' -> result += 5;
                case 'I' -> result += 1;
            }
            cur = sArr[i];
            if ((prev == 'C') & ((cur == 'D') | (cur == 'M'))) {
                result -= 200;
            }
            if ((prev == 'X') & ((cur == 'L') | (cur == 'C'))) {
                result -= 20;
            }
            if ((prev == 'I') & ((cur == 'V') | (cur == 'X'))) {
                result -= 2;
            }
            prev = cur;
        }
        return result;
    }

    //136. Single Number
    public static int singleNumber136(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    //136. Single Number
    public static int singleNumber136_2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    //283. Move Zeroes
    public static int[] moveZeroes_283(int[] nums) {
        int nonZeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != nonZeroCount) {
                    nums[nonZeroCount] = nums[i];
                    nums[i] = 0;
                }
                nonZeroCount++;
            }
        }
        return nums;
    }

    //169. Majority Element
    public static int majorityElement169(int[] nums) {
        Map<Integer, Integer> countElemMap = new HashMap<>();
        int maxIndex = 0;
        for (int i = 0, count = 0, max = 0; i < nums.length; i++) {
            if (countElemMap.containsKey(nums[i])) {
                count = countElemMap.get(nums[i]) + 1;
                countElemMap.replace(nums[i], count);
                if (countElemMap.get(nums[i]) > max) {
                    max = count;
                    maxIndex = i;
                }
            } else {
                count = 1;
                countElemMap.put(nums[i], count);
            }
        }
        return nums[maxIndex];
    }

    public static int majorityElement169_3(int[] nums) {
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length; i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;

        }
        return major;
    }

    //242. Valid Anagram
    public static boolean isAnagram242(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : sChar) {
            if (sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) + 1);
            } else {
                sMap.put(c, 1);
            }
        }
        for (char c : tChar) {
            if (sMap.containsKey(c)) {
                if (sMap.get(c) == 1) {
                    sMap.remove(c);
                } else {
                    sMap.put(c, sMap.get(c) - 1);
                }
            } else {
                return false;
            }
        }
        return sMap.isEmpty();
    }

    //2011. Final Value of Variable After Performing Operations
    public static int finalValueAfterOperations2011(String[] operations) {
        int result = 0;
        for (String str : operations) {
            if (str.contains("--")) {
                result--;
                continue;
            }
            if (str.contains("++")) {
                result++;
                continue;
            }
        }

        return result;
    }

}
