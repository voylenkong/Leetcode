package org.example.task;

import java.util.*;
import java.util.stream.Stream;

public class TaskArray {

    //344. Reverse String
    public String reverseString344_Array(String inputStr) {
        char[] inputStrCh = inputStr.toCharArray();
        for (int i = 0, j = inputStrCh.length - 1; i < j; i++, j--) {
            char swap = inputStrCh[i];
            inputStrCh[i] = inputStrCh[j];
            inputStrCh[j] = swap;
        }
        return String.valueOf(inputStrCh);
    }

    //557. Reverse Words in a String III
    public String reverseWords(String s) {
        StringBuilder resultStrBld = new StringBuilder();
        String[] strs = s.split(" ");
        for (int i = 0; i < strs.length; i++) {
            resultStrBld.append(this.reverseString344_Array(strs[i]));
            if (i < strs.length - 1) {
                resultStrBld.append(" ");
            }
        }
        return resultStrBld.toString();
    }

    //344. Reverse String
    public String reverseString344_Stream(String inputStr) {
        Deque<Character> reverseInputStrCh = new ArrayDeque<>();
        inputStr.chars().forEachOrdered(c -> reverseInputStrCh.push((char)c));
        return Stream.of(reverseInputStrCh).map(String::valueOf).reduce("", (result, c) -> result + c);
    }

    //344. Reverse String
    private StringBuilder resultStr344 = new StringBuilder();

    public String reverseString344_Recursion(String inputStr) {
        if (inputStr.length() > 1) {
            reverseString344_Recursion(inputStr.substring(1));
        }
        this.resultStr344.append(inputStr.charAt(0));
        return resultStr344.toString();
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

    //125. Valid Palindrome
    public static boolean isPalindrome(String s) {
        char[] charS = s.toLowerCase().replaceAll("\\W", "").replaceAll("_", "").toCharArray();
        for (int i = 0, j = charS.length - 1; i < j; i++, j--) {
            if (charS[i] != charS[j]) {
                return false;
            }
        }
        return true;
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

    //771. Jewels and Stones
    public static int numJewelsInStones771(String jewels, String stones) {

        Set<Character> jewelSet = new HashSet<>();
        jewels.chars().forEachOrdered(c -> jewelSet.add((char) c));

        int result = 0;
        char[] stonesCh = stones.toCharArray();

        for (char stone : stonesCh) {
            if (jewelSet.contains(stone)) {
                result += 1;
            }
        }
        return result;
    }

    //228. Summary Ranges

    private String summaryRangesPrint(int a, int b) {
        if (a != b) {
            return (a + "->" + b);
        }
        else {
            return String.valueOf(a);
        }
    }
    public List<String> summaryRanges228(int[] nums) {
        List<String> result = new ArrayList<>();
        if ((nums.length > 0)) {
            int a = nums[0];
            int b = nums[0];
            int prev = nums[0];
            boolean newRange = true;
            int len = nums.length;
            for (int i = 1; i < len; i++) {
                if (nums[i] != (prev + 1)) {
                    newRange = false;
                    b = nums[i - 1];
                }
                if (!newRange) {
                    result.add(this.summaryRangesPrint(a, b));
                    a = nums[i];
                    newRange = true;
                }
                prev = nums[i];
                if (i == len - 1) {
                    b = nums[i];
                }
            }
            result.add(this.summaryRangesPrint(a, b));
        }
        return result;
    }

    //268. Missing Number
    public static int missingNumber(int[] nums) {
        int result = 0;
        short i = 0;
        while (i < nums.length) {
            result += i;
            result -= nums[i];
            i++;
        }
        result += i;
        return result;
    }

    //20. Valid Parentheses
    public static boolean isValid20(String s) {
        char[] charS = s.toCharArray();
        Deque<Character> sStack = new ArrayDeque<>();
        char popChar;
        for (char c : charS) {
            if ((c == '(') || (c == '{') || (c =='[')) {
                sStack.push(c);
            } else {
                if (sStack.isEmpty()) {
                    return false;
                }
                popChar = sStack.pop();
                if (
                        !((c == ')') & (popChar == '(')) &&
                        !((c == '}') & (popChar == '{')) &&
                        !((c == ']') & (popChar == '['))) {
                    return false;
                }
            }
        }
        return sStack.isEmpty();
    }

    //977. Squares of a Sorted Array
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *=nums[i];
        }
        return Arrays.stream(nums).sorted().toArray();
    }

    public long convertStrToLong(String str) {
        char[] strCh = str.toCharArray();
        long result = 0;
        long j = 1;
        for (int i = strCh.length - 1; i >= 0; i--) {
            result += (strCh[i] - '0') * j;
            j *= 10;
        }
        return result;
    }

    //415. Add Strings
    public String addStrings(String num1, String num2) {
        char[] num1Ch = num1.toCharArray();
        char[] num2Ch = num2.toCharArray();
        int extraRank = 0;
        int cur = 0;
        int i = num1Ch.length - 1;
        int j = num2Ch.length - 1;
        StringBuilder result = new StringBuilder();
        while (i >= 0 && j >= 0) {
            cur = (num1Ch[i] - '0') + (num2Ch[j] - '0') + extraRank;
            extraRank = 0;
            if (cur >= 10) {
                extraRank = 1;
                cur %= 10;
            }
            result.insert(0, cur);
            i--;
            j--;
        }
        if (i < 0 & j >= 0) {
            i = j;
            num1Ch = num2Ch;
        }
        while (i >= 0) {
            if (extraRank != 0) {
                cur = (num1Ch[i] - '0') + extraRank;
                if (cur >= 10) {
                    cur %= 10;
                } else {
                    extraRank = 0;
                }
                result.insert(0, cur);
            } else {
                result.insert(0, num1Ch[i]);
            }
            i--;
        }
        if (extraRank != 0) {
            result.insert(0, extraRank);
        }
        return result.toString();
    }


    //1446. Consecutive Characters
    public int maxPower(String s) {
        char[] sCh = s.toCharArray();
        char prevCh = sCh[0];
        int pow = 1;
        int curPow = 1;
        for (int i = 1; i < sCh.length; i++) {
            if (prevCh == sCh[i]) {
                curPow++;
                if (pow < curPow) {
                    pow = curPow;
                }
            } else {
                prevCh = sCh[i];
                curPow = 1;
            }
        }
        return pow;
    }

    //167. Two Sum II - Input Array Is Sorted
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i != j) {
            if ((numbers[i] + numbers[j]) > target) {
                j--;
            }
            else if ((numbers[i] + numbers[j]) < target) {
                i++;
            }
            else if ((numbers[i] + numbers[j]) == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }

    //350. Intersection of Two Arrays II
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> tempList = new ArrayList<>();
        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                pointer2++;
            } else {
                tempList.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            }
        }

        int[] result = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            result[i] = tempList.get(i);
        }

        return result;
    }
}
