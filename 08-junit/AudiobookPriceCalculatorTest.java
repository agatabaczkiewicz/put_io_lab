package put.io.testing.audiobooks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import put.io.testing.junit.Calculator;

class AudiobookPriceCalculatorTest {



    @Test
    public void test(){
        Customer customer;
        customer = new Customer("Basia", Customer.LoyaltyLevel.STANDARD,false);
        Audiobook audiobook=new Audiobook("Zabicdrozda",40);
        AudiobookPriceCalculator acal=new AudiobookPriceCalculator();
        assertEquals(40,acal.calculate(customer,audiobook));
    }

    @Test
    public void test2(){
        Customer customer;
        customer = new Customer("Basia", Customer.LoyaltyLevel.STANDARD,true);
        Audiobook audiobook=new Audiobook("Zabicdrozda",40);
        AudiobookPriceCalculator acal=new AudiobookPriceCalculator();
        assertEquals(0.0,acal.calculate(customer,audiobook));
    }
    @Test
    public void test3(){
        Customer customer;
        customer = new Customer("Basia", Customer.LoyaltyLevel.SILVER,false);
        Audiobook audiobook=new Audiobook("Zabicdrozda",40);
        AudiobookPriceCalculator acal=new AudiobookPriceCalculator();
        assertEquals(36.0,acal.calculate(customer,audiobook));
    }
    @Test
    public void test4(){
        Customer customer;
        customer = new Customer("Basia", Customer.LoyaltyLevel.GOLD,false);
        Audiobook audiobook=new Audiobook("Zabicdrozda",40);
        AudiobookPriceCalculator acal=new AudiobookPriceCalculator();
        assertEquals(32.0,acal.calculate(customer,audiobook));
    }

}