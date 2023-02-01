import constants.ExpenseSplitType;
import controllers.ExpenseController;
import controllers.GroupController;
import controllers.UserController;
import models.Expense;
import models.Group;
import models.Split;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private static GroupController groupController;
    private static UserController userController;
    private static ExpenseController expenseController;

    public static void main(String[] args) {
        addUsers();
        addGroups();
        addExpenses();
        printBalanceSheet();
    }

    private static void printBalanceSheet() {
        userController.getUserByName("Goutam").printBalanceSheet();
        userController.getUserByName("Suman").printBalanceSheet();
        userController.getUserByName("Piyush").printBalanceSheet();
        userController.getUserByName("Kaushal").printBalanceSheet();

        groupController.getGroupByName("Bangalore-Group").printExpensesInGroup();
    }

    private static void addExpenses() {
        expenseController = new ExpenseController();

        Expense expense1 = new Expense();
        expense1.setDescription("Lunch");
        expense1.setAmount(1000);
        expense1.setExpenseSplitType(ExpenseSplitType.EQUAL);
        expense1.setPaidBy(userController.getUserByName("Goutam"));
        expense1.setSharedWith(userController.getUserByName("Suman"));
        expense1.setSplitDetails(new ArrayList<>());
        expenseController.createExpense(expense1);

        Expense expense2 = new Expense();
        expense2.setDescription("Dinner");
        expense2.setAmount(3000);
        expense2.setExpenseSplitType(ExpenseSplitType.EQUAL);
        expense2.setPaidBy(userController.getUserByName("Goutam"));
        expense2.setSharedWith(groupController.getGroupByName("Bangalore-Group"));
        expense2.setSplitDetails(new ArrayList<>());
        expenseController.createExpense(expense2);

        Expense expense3 = new Expense();
        expense3.setDescription("Flight");
        expense3.setAmount(16000);
        expense3.setExpenseSplitType(ExpenseSplitType.UNEQUAL);
        expense3.setPaidBy(userController.getUserByName("Piyush"));
        expense3.setSharedWith(userController.getUserByName("Goutam"));
        List<Split> splits = new ArrayList<>();
        splits.add(new Split(userController.getUserByName("Piyush"), 6000.0));
        splits.add(new Split(userController.getUserByName("Goutam"), 10000.0));
        expense3.setSplitDetails(splits);
        expenseController.createExpense(expense3);
    }

    private static void addGroups() {
        groupController = new GroupController();
        groupController.createGroup(new Group("Bangalore-Group",
                userController.getUserByName("Goutam")));
        groupController.addMemberInExistingGroup("Bangalore-Group",
                userController.getUserByName("Piyush"));
        groupController.addMemberInExistingGroup("Bangalore-Group",
                userController.getUserByName("Kaushal"));
    }

    private static void addUsers() {
        userController = new UserController();
        userController.addUser(new User("Goutam", "goutam@gmail.com"));
        userController.addUser(new User("Suman", "suman@gmail.com"));
        userController.addUser(new User("Ram", "ram@gmail.com"));
        userController.addUser(new User("Piyush", "p@gmail.com"));
        userController.addUser(new User("Kaushal", "kaushal@gmail.com"));
    }
}
