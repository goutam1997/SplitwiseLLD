package expenses;

import models.Expense;
import models.User;

import java.util.Map;

public interface CanShareExpense {
    Map<User, Double> shareExpense(Expense expense);
}
