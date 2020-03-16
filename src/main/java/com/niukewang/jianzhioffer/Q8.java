package com.niukewang.jianzhioffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 */
public class Q8 {
    public double Power(double base, int exponent) {

        if(base==0){
            return 0;
        }

        if(exponent==0){
            return 1;
        }else if(exponent>0){
            double i = base;
            while(exponent>1){
                base*= i;
                exponent--;
            }
            return base;
        }else{
            exponent = -exponent;
            return 1/Power(base,exponent);
        }
    }
}
