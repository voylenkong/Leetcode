package org.example.task;

public class TaskSimple {
    //191. Number of 1 Bits
    public static int hammingWeight191(int n) {
        int count = 0;
        while (n!=0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    public static int hammingWeight191_2(int n) {
        int count = 0;
        while (n!=0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    //1108. Defanging an IP Address
    public static String defangIPaddr1108(String address) {
        return address.replace(".", "[.]");
    }

    //2235. Add Two Integers
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    //2469. Convert the Temperature
    public static double[] convertTemperature2469(double celsius) {
        double[] result = new double[2];
        result[0] = celsius + 273.15;
        result[1] = celsius * 1.80 + 32.00;

        return result;
    }
}
