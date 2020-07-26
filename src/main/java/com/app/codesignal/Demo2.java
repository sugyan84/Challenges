package com.app.codesignal;

public class Demo2 {

    public static void main(String[] args) {
        int[] nums = { 3, 0, -2, 6, -3, 2 };
        int[][] queries = { { 0, 2 }, { 2, 5 }, { 0, 5 } };
        long mod = (long) (Math.pow(10, 9) + 7);

        System.out.println(sumInRange(nums, queries) % mod);
    }

    static int sumInRange(int[] nums, int[][] queries) {
        int querySum = 0;
        if (nums != null && queries != null) {
            int[] sumArr = new int[nums.length];

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sumArr[i] = sum;
            }

            //Arrays.stream(sumArr).forEach(System.out::println);

            for (int i = 0; i < queries.length; i++) {
                querySum += findSum(queries[i][0], queries[i][1], sumArr);
            }
        }
        return querySum;
    }

    private static int findSum(final int startIndex, final int endIndex, final int[] sumArr) {
        if (startIndex == 0) {
            return sumArr[endIndex];
        } else {
            int before = sumArr[startIndex - 1];
            int full = sumArr[endIndex];
            return full - before;
        }
    }

}
