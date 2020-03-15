package com.niukewang.jianzhioffer;

/***
 *
 * @author JACKPOT
 */
public class Q6 {
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int JumpFloorII(int target) {
        if (target == 0 || target == 1) {
            return 1;
        }
        int val = 0;
        for (int i = 0; i < target; i++) {
            val += JumpFloorII(i);
        }
        return val;
    }
}
