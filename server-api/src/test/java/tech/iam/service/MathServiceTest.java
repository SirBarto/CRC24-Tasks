package tech.iam.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class MathServiceTest {

    MathService mathService = new MathService();

    @Test
    void addOutOfScopeValues(){
        //given
        var number_1 = Integer.MAX_VALUE;
        var number_2 = Integer.MAX_VALUE;

        //when
        //then
        assertThrows(ArithmeticException.class,()->mathService.add(number_1, number_2));
    }

    @Test
    void addCorrectValues(){
        //given
        var EXPECTED_VALUE = 5;
        var number_1 = 2;
        var number_2 = 3;

        //when
        //then
        assertEquals(EXPECTED_VALUE,mathService.add(number_1, number_2));
    }

    @Test
    void divide(){
        //given
        var EXPECTED_VALUE = 5;
        var number_1 = 25;
        var number_2 = 5;

        //when
        //then
        assertEquals(EXPECTED_VALUE,mathService.divide(number_1, number_2));
    }

    @Test
    void divideByZero(){
        //given
        var number_1 = 25;
        var number_2 = 0;

        //when
        //then
        assertThrows(ArithmeticException.class,()->mathService.divide(number_1, number_2));
    }

}