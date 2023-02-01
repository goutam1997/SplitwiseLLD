package controllers;

import models.Expense;
import models.Group;
import models.User;

import java.util.Map;

public class ExpenseController {
    private BalanceSheetController balanceSheetController;

    public void createExpense(Expense expense) {
        balanceSheetController = new BalanceSheetController();
        User paidByUser = expense.getPaidBy();
        Map<User, Double> contibutionMap = expense.getSharedWith().shareExpense(expense);
        balanceSheetController.updateUserBalanceSheet(paidByUser, expense.getAmount(), contibutionMap);
    }


}
