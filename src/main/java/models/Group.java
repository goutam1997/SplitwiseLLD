package models;

import constants.ExpenseSplitType;
import controllers.ExpenseController;
import expenses.CanShareExpense;
import expenses.SplitTypeFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Group implements CanShareExpense {
    private final String groupName;
    private List<User> groupMembers;
    private List<Expense> expenseList;

    public Group(String groupName, User createdBy){
        this.groupName = groupName;
        this.groupMembers = new ArrayList<>();
        this.expenseList = new ArrayList<>();
        this.groupMembers.add(createdBy);
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getGroupMembers() {
        return groupMembers;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void addMemberToGroup(User user) {
        if (duplicateMemebr(user)) {
            return;
        }
        groupMembers.add(user);
    }

    private boolean duplicateMemebr(User cur) {
        for (User user: groupMembers) {
            if (user.getUserName().equals(cur.getUserName())){
                return true;
            }
        }
        return false;
    }

    public void printExpensesInGroup() {
        System.out.println(groupName+" -> " + expenseList);
    }

    @Override
    public Map<User, Double> shareExpense(Expense expense) {
        expenseList.add(expense);
        SplitTypeFactory splitTypeFactory = new SplitTypeFactory();
        return splitTypeFactory.getExpenseSplit(expense.getExpenseSplitType()).getContributionMap(expense.getAmount(),
                groupMembers, expense.getSplitDetails());
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", groupMembers=" + groupMembers +
                '}';
    }
}
