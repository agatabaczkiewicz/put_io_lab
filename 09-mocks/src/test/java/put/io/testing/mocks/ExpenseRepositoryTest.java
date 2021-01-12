package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//import org.junit.*;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;
import java.util.List;
import java.util.Collections;

public class ExpenseRepositoryTest {

    @Test
    void testLE(){
        IFancyDatabase myDatabase = mock(MyDatabase.class);
        when(myDatabase.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository ex = new ExpenseRepository(myDatabase);
        ex.loadExpenses();
        InOrder inOrder=inOrder(myDatabase);
        inOrder.verify(myDatabase).connect();
        inOrder.verify(myDatabase).queryAll();
        inOrder.verify(myDatabase).close();
        assertTrue(ex.getExpenses().isEmpty());
    }

    @Test
    void testSE(){
        IFancyDatabase myDatabase = mock(MyDatabase.class);
        when(myDatabase.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository ex = new ExpenseRepository(myDatabase);
        Expense expense = new Expense();
        ex.loadExpenses();


        for (int i =0; i<5; i++){
            ex.addExpense(expense);
        }
        ex.saveExpenses();
        verify(myDatabase,times(5)).persist(any(Expense.class));

    }

}
