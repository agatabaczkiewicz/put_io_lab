package put.io.testing.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


class FailureOrErrorTest {
    @Test
    public void test1(){
        Calculator cal= new Calculator() ;
        assertEquals(2,cal.add(2,2));
    }
    @Test
    public void test2(){
        Calculator cal= new Calculator() ;
        cal.addPositiveNumbers(2,-2);


    }
    @Test
    public void test3(){
        try{
            Calculator cal= new Calculator() ;
            assertEquals(2,cal.add(2,2));
        }
        catch(Throwable e){
            e.printStackTrace();
        }
    }
}