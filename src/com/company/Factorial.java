package com.company;


class Factorial {

    long result = 1;

    public Factorial(int n) {
        for (long i = 1; i <= n; i++) {
            result *= i;
        }

    }

    public long factoring(long x) {
        result = 1;
        for (long i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public long getFactorial() {
        return result;
    }
}
