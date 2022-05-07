package com.example.demo2.bean;

import com.example.demo2.Calculator;

public class MulCalculator implements Calculator {
    @Override
    public int calc(int a, int b) {
        return a * b;
    }
}
