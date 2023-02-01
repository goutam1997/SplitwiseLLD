package models;

import constants.ExpenseSplitType;
import expenses.CanShareExpense;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    private String description;
    private double amount;
    private User paidBy;
    private ExpenseSplitType expenseSplitType;
    private CanShareExpense sharedWith;
    private List<Split> splitDetails = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public ExpenseSplitType getExpenseSplitType() {
        return expenseSplitType;
    }

    public void setExpenseSplitType(ExpenseSplitType expenseSplitType) {
        this.expenseSplitType = expenseSplitType;
    }

    public CanShareExpense getSharedWith() {
        return sharedWith;
    }

    public void setSharedWith(CanShareExpense sharedWith) {
        this.sharedWith = sharedWith;
    }

    public List<Split> getSplitDetails() {
        return splitDetails;
    }

    public void setSplitDetails(List<Split> splitDetails) {
        this.splitDetails = splitDetails;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", paidBy=" + paidBy +
                ", expenseSplitType=" + expenseSplitType +
                ", sharedWith=" + sharedWith +
                ", splitDetails=" + splitDetails +
                '}';
    }
}
