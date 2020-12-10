package put.io.testing.junit;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator=new Calculator();
    }
    @Test
    public void testAdd(){

        assertEquals(5,calculator.add(2,3));
        assertEquals(0,calculator.add(0,0));
    }

    @Test
    public void testMultiply(){

        assertEquals(6,calculator.multiply(2,3));
        assertEquals(0,calculator.multiply(0,3));

    }

    @Test
    public void testAddPositive(){

        assertThrows(IllegalArgumentException.class, () ->{
            calculator.addPositiveNumbers(0,0);
            calculator.addPositiveNumbers(5,8);
            calculator.addPositiveNumbers(5,-1);
        });


    }



}