package tech.iam.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {


    public int add(int number1, int number2) {
        //return number1 + number2;
        return Math.addExact(number1, number2);
    }
}
