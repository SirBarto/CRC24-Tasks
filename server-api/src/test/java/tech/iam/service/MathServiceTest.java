package tech.iam.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class MathServiceTest {

    MathService mathService = new MathService();

    @Test
    void add(){
        //given
        var EXPECTED_VALUE = 5;
        var number_1 = Integer.MAX_VALUE;
        var number_2 = Integer.MAX_VALUE;

        //when
        //then
        //assertEquals(EXPECTED_VALUE,mathService.add(number_1,number_2));
        assertThrows(ArithmeticException.class,()->mathService.add(number_1, number_2));
    }
}