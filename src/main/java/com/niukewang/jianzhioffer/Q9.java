package com.niukewang.jianzhioffer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Q9 {

    public static void main(String[] args) {
        int[] array = {2, 1, 23, 44, 5, 6, 4, 99, 2, 43, 34, 3, 5235, 2, 2, 4, 234, 24};
        //int[] array = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray(array);

        //System.arraycopy(array,0,array,3,2);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 循环遍历数组,记录下第一个遇到的偶数的索引,以及下一个遇到的奇数的索引,判断这个奇数之前有没有偶数,如果有就把遇到这个奇数之前的所有偶数向后移动一个位置
     * 然后在把奇数插入到这串偶数前面
     *
     * @param array 目标数组
     */
    public static void reOrderArray(int[] array) {
        //如果数组长度为零,直接结束方法
        if (array.length == 0) {
            return;
        }
        int length = array.length;
        //数组第一个偶数的索引,默认为-1
        int firstEvenIndex = -1;
        //标记奇数应该往前插的位置,如果index=0的时候数组是奇数,那么第一个遇到的奇数应该插入到index=1的位置
        int oddIndexFlag = 0;
        //记录下第一个遇到的奇数的值
        int targetOdd = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] % 2 == 1) {
                //说明是奇数,判断此数之前有没有偶数
                if (i > firstEvenIndex && firstEvenIndex != -1) {
                    //说明此奇数前面有偶数,记下这个奇数,并把前面的偶数都往后挪一个位置,把此数插在相应的位置
                    targetOdd = array[i];
                    //把整个偶数向后移动一位
                    System.arraycopy(array, firstEvenIndex, array, firstEvenIndex + 1, i - firstEvenIndex);
                    array[oddIndexFlag] = targetOdd;
                    //因为偶数向后移动了一位,所以数组中第一个偶数的索引也向后移动了一位
                    firstEvenIndex = firstEvenIndex + 1;
                }
                oddIndexFlag++;
            } else {
                //说明是偶数,记录下第一次遇到偶数时候的索引
                if (firstEvenIndex == -1) {
                    firstEvenIndex = i;
                }
            }
        }
    }


    public static void reOrderArray2(int[] array) {
        int i = 0;
        int j = array.length;
        int index = -1;
        if (array.length == 0) {  //数组为空，啥也不干！
            return;
        }
        while (i < j) {
            if ((array[i] & 1) == 1) {
                if (index >= 0) {
                    //和index位置元素交换
                    int ss = array[i];
                    if (i - index >= 0) System.arraycopy(array, index, array, index + 1, i - index);
                    array[index] = ss;
                    index++;
                }
                i++;
            } else {
                //这里很关键，需要记住从左边开始的第一个偶数的位置，如果第一个元素就是偶数，这个临界值一定要考虑到。
                //如果第一个元素不是偶数，那当遍历到第一个偶数的时候，开始记住其角标。
                if (i == 0)
                    index = 0;
                if (index < 0)
                    index = i;
                i++;
            }
        }
    }
}


