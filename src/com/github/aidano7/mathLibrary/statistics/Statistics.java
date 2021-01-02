package com.github.aidano13.mathLibrary.statistics;

public class Statistics {

    private static float sum(float[] nums) {
        float sum = 0;

        for (float num : nums) {
            sum += num;
        }

        return sum;
    }

    public static float mean(float[] nums) {
        return sum(nums) / nums.length;
    }

    public static float median(float[] nums) {
        return 0;
    }

    public static float mode(float[] nums) {
        return 0;
    }

    public static float range(float[] nums) {
        return 0;
    }
}
