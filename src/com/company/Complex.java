package com.company;


public class Complex{

    double real;
    double imaginary;

    //  Generators

    public Complex(){
        real = 0;
        imaginary = 0;
    }
    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    public Complex(Complex complex){
        real = complex.real;
        imaginary = complex.imaginary;
    }



    public static long factoring(int x){
        long result = 1;
        for(long i = 1; i<=x; i++){
            result *= i;
        }
        return result;
    }




    public static Complex sum(Complex complex1, Complex complex2){
        return new Complex (complex1.real+complex2.real, complex1.imaginary +complex2.imaginary);
    }

    public static Complex minus(Complex complex1, Complex complex2){
        return new Complex (complex1.real-complex2.real, complex2.imaginary -complex2.imaginary);
    }

    public static Complex multi(Complex complex1, Complex complex2){
        return new Complex (complex1.real*complex2.real+complex1.imaginary +complex2.imaginary,complex1.real*complex2.imaginary + complex1.imaginary *complex2.real);//(real1*real2 + img1*img2 )  +  ( real1*img2  +  img1*real2)
    }

    public static Complex div(Complex complex1, Complex complex2){
        return new Complex((complex1.real/complex2.real+complex1.imaginary/complex2.imaginary), (complex1.imaginary/complex2.real+complex1.real/complex2.imaginary));
    }


    public static void square(Complex complex){
        complex.real = complex.real*complex.real -complex.imaginary*complex.imaginary;
        complex.imaginary = -2*complex.real*complex.imaginary;
    }
    public void square(){
        real = real*real - imaginary*imaginary;
        imaginary = -2*real*imaginary;
    }

    public static double abs(Complex complex){
        return Math.sqrt(complex.real*complex.real + complex.imaginary*complex.imaginary);
    }

    public static boolean equals(Complex complex1, Complex complex2){
        if(complex1.real == complex2.real && complex1.imaginary == complex2.imaginary){
            return true;
        }else{
            return false;
        }
    }


    public static Complex neg(Complex complex){
        return new Complex(-complex.real, -complex.imaginary);
    }


    public static Complex pow(Complex z, int n){

        Complex result = new Complex();
        result.real = Math.pow( z.real , n );
        for(int j = 1; j<n; j++){
            if(j%2==0){
                result.real += ( (int)( ( factoring(n) ) / ( factoring(j) * factoring(n-j) ))) * Math.pow(z.real, n-j) * (j%4==0? Math.pow(z.imaginary, j) : -Math.pow(z.imaginary, j) );
            }else{
                result.imaginary += ( (int)( ( factoring(n) ) / ( factoring(j) * factoring(n-j) ))) * Math.pow(z.real, n-j) * ( (j-1)%4==0? Math.pow(z.imaginary, j) : -Math.pow(z.imaginary, j) );
            }
        }

        return result;

    }

    public static double getArgument(Complex complex){ //angle φ
        return Math.atan(complex.imaginary/complex.real);
    }

    public static  Complex z_parse(Complex complex){
        return new Complex(abs(complex)*Math.cos(getArgument(complex)), abs(complex)*Math.sin(getArgument(complex)));
    }

    public Complex z_parse(){   ////    todo:   степень не должна равняться единице
        return new Complex(abs(new Complex(real, imaginary))*Math.cos(getArgument(new Complex(real, imaginary))), abs(new Complex(real, imaginary))*Math.sin(getArgument(new Complex(real, imaginary))));
    }

    //// TODO: 15.11.2019 Нужен перевод из дессятичной в обыкновенную дробь
    /*

    public static Complex pow(Complex z, double n){
        return multi(pow(z,Math.floor(n)),
    }

    public static Complex sqrt(){

    }

    String eString() {  //returns trigonometric representation "r cos φ + i sin φ"

    }

     */

    @Override
    public String toString(){
        return real+"h "+imaginary+"i" ;
    }


    public double getReal(){
        return real;
    }
    public double getImaginary(){
        return imaginary;
    }
    public void setReal(double real){
        this.real = real;
    }
    public void setImaginary(double imaginary){
        this.imaginary = imaginary;
    }
    public void conjugate(){
        this.imaginary = -this.imaginary;
    }
    public boolean checkReal(){
        return real != 0;
    }
    public boolean checkImaginary(){
        return  imaginary != 0;
    }



    public static void printComplex(Complex complex){
        System.out.print("real " + complex.real  +  "\timaginary " + complex.imaginary);
    }
    public static void printComplex(Complex complex, String s){
        System.out.print("real " + complex.real  +  "\timaginary " + complex.imaginary + s);
    }
    public void printComplex(){
        System.out.print("real " + real  +  "\timaginary " + imaginary);
    }
    public void printComplex(String s){
        System.out.print("real " + real  +  "\timaginary " + imaginary + s);
    }

}
