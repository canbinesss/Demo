package com.example.utils;

/**
 * @author kangzhongbin
 * @date 2022年02月25日23:10
 */
public class Test {

    public static void main(String[] args) {
        int[] a = {2, 20, 23, 4, 8};
        Test test = new Test();
        String as = test.solve(a);
        System.out.println(as);
    }

    public String solve(int[] nums) {
        double temp;//定义一个临时变量
        // write code here
        double[] newnums = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newnums[i] = Double.parseDouble(Integer.toString(nums[i]).substring(0, 1) + "." + Integer.toString(nums[i]).substring(1, Integer.toString(nums[i]).length()));
        }
        for (int i = 0; i < newnums.length - 1; i++) {//冒泡趟数
            for (int j = 0; j < newnums.length - i - 1; j++) {
                if (newnums[j + 1] > newnums[j]) {
                    temp = newnums[j];
                    newnums[j] = newnums[j + 1];
                    newnums[j + 1] = temp;
                }
            }
        }
        String str = "";
        for (int i = 0; i < newnums.length; i++) {//冒泡趟数
            str += newnums[i];
        }
        return str.replaceAll(".", "");
    }
}
