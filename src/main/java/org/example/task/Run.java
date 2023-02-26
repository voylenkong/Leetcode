package org.example.task;


import java.time.LocalTime;

public class Run {
    public static void main(String[] args) {
        TaskArray taskArray = new TaskArray();
        int[] result = taskArray.twoSum(new int[] {-1,0}, -1);
        System.out.println(result[0] + "; " + result[1]);


    }
}
