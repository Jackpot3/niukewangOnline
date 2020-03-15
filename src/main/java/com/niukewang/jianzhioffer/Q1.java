package com.niukewang.jianzhioffer;

import com.niukewang.utils.TimeWatch;

import java.util.Arrays;

/***
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author JACKPOT
 *
 * 数组有length属性 没有length()方法 int[i][j]数组的长度为i 二维数组中的元素可以为空数组
 *
 */
public class Q1 {

    private static int[][] targetArray = new int[10000][10000];

    static {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                targetArray[i][j] = 10000 * i + j;
            }
        }
    }

    public static void main(String[] args) {
        TimeWatch.begin();
        System.out.println(find(99999999, targetArray));
        TimeWatch.end();

    }

    public static boolean find(int target, int[][] array) {
        int length = array.length;
        if (length == 0) {
            return false;
        }
        //整个二维数组中的最大值 排除空数组的情况
        int[] lastArray = array[length - 1];
        int lastIndex = lastArray.length - 1;
        if (lastIndex < 0) {
            return false;
        }
        int maxValue = lastArray[lastIndex];
        //整个二维数组中的最小值
        int minValue = array[0][0];

        if (target > maxValue || target < minValue) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            int[] ints = array[i];
            if (ints[0] > target || ints[ints.length - 1] < target) {
                continue;
            }
            for (int j : ints) {
                //这边还能换成二分查找法效率更快
                if (j == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find2(int target, int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (target == anInt) {
                    return true;
                }
            }
        }
        return false;
    }
}
