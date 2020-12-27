package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//import org.junit.*;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.students.fancylibrary.service.FancyService;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseManagerTest {

    @Test
    void testCalculateTotal() {
        ExpenseRepository er = mock(ExpenseRepository.class);
        List<Expense> e = new ArrayList<>();
        Expense ex = new Expense();
        for (int i = 0; i < 3; i++) {
            e.add(ex);
        }
        when(er.getExpenses()).thenReturn(e);
        FancyService fs = new FancyService();
        ExpenseManager em = new ExpenseManager(er, fs);
        int sum = 0;
        for (Expense expense : e) {
            sum += expense.getAmount();
        }
        assertEquals(em.calculateTotal(), sum);
    }
    private List<Expense> HomeList() {
        List<Expense> list = new ArrayList<>();
        list.add(new Expense("Cup", "Home", 15));
        list.add(new Expense("Pillow", "Home", 40));

        return list;
    }

    private List<Expense> CarList() {
        List<Expense> list = new ArrayList<>();
        list.add(new Expense("Fuel", "Car", 200));
        list.add(new Expense("CarWash", "Car", 100));
        return list;
    }
        @Test
        void testCalculateForCategory(){
            ExpenseRepository er = mock(ExpenseRepository.class);
            FancyService fs = new FancyService();
            ExpenseManager em = new ExpenseManager(er, fs);
            when(er.getExpensesByCategory(anyString())).thenReturn(new ArrayList<>());
            when(er.getExpensesByCategory(eq("Home"))).thenReturn(HomeList());
            when(er.getExpensesByCategory(eq("Car"))).thenReturn(CarList());

            assertEquals(55,em.calculateTotalForCategory("Home"));
            assertEquals(300,em.calculateTotalForCategory("Car"));
            assertEquals(0,em.calculateTotalForCategory("Food"));

        }

        @Test
        void testCalculateTotalInDollars() throws ConnectException {
            FancyService fs = mock(FancyService.class);
            ExpenseRepository er = mock(ExpenseRepository.class);
            when(er.getExpenses()).thenReturn(CarList());
            when(fs.convert(anyDouble(),eq("PLN"),eq("USD"))).thenAnswer(i -> i.getArgument(0, Double.class) / 4.0);

            ExpenseManager em = new ExpenseManager(er, fs);
            assertEquals(75,em.calculateTotalInDollars());

        }

}
