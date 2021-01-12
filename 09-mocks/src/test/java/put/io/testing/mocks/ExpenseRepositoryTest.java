package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.students.fancylibrary.database.FancyDatabase;

import org.mockito.*;

import java.util.Collections;

public class ExpenseRepositoryTest {

    @Test
    void testLE(){
        IFancyDatabase base = mock(MyDatabase.class);
        when(base.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository exRepo = new ExpenseRepository(base);
        exRepo.loadExpenses();
        InOrder inOrder=inOrder(base);
        inOrder.verify(base).connect();
        inOrder.verify(base).queryAll();
        inOrder.verify(base).close();
        assertTrue(exRepo.getExpenses().isEmpty());
    }

    @Test
    void testSE(){
        IFancyDatabase base = mock(MyDatabase.class);
        when(base.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository exRepo = new ExpenseRepository(base);
        Expense expense = new Expense();
        exRepo.loadExpenses();

        for (int i =0; i<5; i++){
            exRepo.addExpense(expense);
        }
        exRepo.saveExpenses();
        verify(base,times(5)).persist(any(Expense.class));

    }

}