package org.example.task;

public class Task {

    //#344. Reverse String
    public static String revertString(String inputStr) {
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
}
