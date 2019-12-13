package com.company;


class factorial{
    long result = 1;
    public factorial(int n){
        for(long i = 1; i<=n; i++){
            result *= i;
        }

    }
    public long factoring(long x){
        result = 1;
        for(long i = 1; i<=x; i++){
            result *= i;
        }
        return result;
    }
    public long getFactorial(){
        return result;
    }
}
