package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        ExpenseRepository exRepo = mock(ExpenseRepository.class);
        List<Expense> e = new ArrayList<>();
        Expense ex = new Expense();
        for (int i = 0; i < 3; i++) {
            e.add(ex);
        }
        when(exRepo.getExpenses()).thenReturn(e);
        FancyService fancyServ = new FancyService();
        ExpenseManager exMan = new ExpenseManager(exRepo, fancyServ);
        int sum = 0;
        for (Expense expense : e) {
            sum += expense.getAmount();
        }
        assertEquals(exMan.calculateTotal(), sum);
    }
    private List<Expense> HomeList() {
        List<Expense> list = new ArrayList<>();
        list.add(new Expense("Chair", "Home", 33));
        list.add(new Expense("Glasses", "Home", 11));

        return list;
    }

    private List<Expense> CarList() {
        List<Expense> list = new ArrayList<>();
        list.add(new Expense("Service", "Car", 431));
        list.add(new Expense("Oil", "Car", 53));
        return list;
    }
    @Test
    void testCalculateForCategory(){
        ExpenseRepository exRepo = mock(ExpenseRepository.class);
        FancyService fancyServ = new FancyService();
        ExpenseManager exMan = new ExpenseManager(exRepo, fancyServ);
        when(exRepo.getExpensesByCategory(anyString())).thenReturn(new ArrayList<>());
        when(exRepo.getExpensesByCategory(eq("Home"))).thenReturn(HomeList());
        when(exRepo.getExpensesByCategory(eq("Car"))).thenReturn(CarList());

        assertEquals(44,exMan.calculateTotalForCategory("Home"));
        assertEquals(484,exMan.calculateTotalForCategory("Car"));
        assertEquals(0,exMan.calculateTotalForCategory("Food"));

    }

    @Test
    void testCalculateTotalInDollars() throws ConnectException {
        FancyService fancyServ = mock(FancyService.class);
        ExpenseRepository exRepo = mock(ExpenseRepository.class);
        when(exRepo.getExpenses()).thenReturn(CarList());
        when(fancyServ.convert(anyDouble(),eq("PLN"),eq("USD"))).thenAnswer(i -> i.getArgument(0, Double.class) / 4.0);

        ExpenseManager exMan = new ExpenseManager(exRepo, fancyServ);
        assertEquals(121,exMan.calculateTotalInDollars());

    }

}