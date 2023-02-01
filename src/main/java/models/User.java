package models;

import constants.ExpenseSplitType;
import controllers.BalanceSheetController;
import expenses.CanShareExpense;
import expenses.SplitTypeFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class User implements CanShareExpense {
    private final String userName;
    private final String userEmail;
    private UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public Map<User, Double> shareExpense(Expense expense) {
        SplitTypeFactory splitTypeFactory = new SplitTypeFactory();
        List<User> sharedWithMemebers = new ArrayList<>();
        sharedWithMemebers.add(this);
        sharedWithMemebers.add((User)expense.getSharedWith());
        return splitTypeFactory.getExpenseSplit(expense.getExpenseSplitType()).getContributionMap(expense.getAmount(),
                sharedWithMemebers, expense.getSplitDetails());
    }

    public void printBalanceSheet() {
        System.out.println(this.userName+" -> " + this.userExpenseBalanceSheet);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
