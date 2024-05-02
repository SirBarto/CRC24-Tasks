package tech.iam.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {


    public int add(int number1, int number2) {
        //return number1 + number2;
        return Math.addExact(number1, number2);
    }

    /*
    Subtract two integers
    */
    public int subtract(int a, int b) {
        return a - b;
    }


    /*
        Multiply two integers
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /*
        Divide two integers. Informs user if second variable equals zero
     */
    public int divide(int a, int b) {
        return Math.floorDiv(a, b);
    }
}
