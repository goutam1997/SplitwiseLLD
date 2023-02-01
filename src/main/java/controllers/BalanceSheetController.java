package controllers;

import models.User;
import models.UserExpenseBalanceSheet;

import java.util.Map;

public class BalanceSheetController {

    public synchronized void updateUserBalanceSheet(User paidByUser, double amount, Map<User, Double> contibutionMap) {
        UserExpenseBalanceSheet paidByUserExpenseBalanceSheet = paidByUser.getUserExpenseBalanceSheet();
        paidByUserExpenseBalanceSheet.setTotalPaid(paidByUserExpenseBalanceSheet.getTotalPaid() + amount);

        for (User owedMember : contibutionMap.keySet()) {
            if (paidByUser.getUserName().equals(owedMember.getUserName())) {
                continue;
            }
            double owedAmount = contibutionMap.get(owedMember);
            paidByUserExpenseBalanceSheet.setTotalGetBack(paidByUserExpenseBalanceSheet.getTotalGetBack() + owedAmount);
            Map<String, Double> paidUserFriendsBalance = paidByUserExpenseBalanceSheet.getFriendsBalance();
            paidUserFriendsBalance.put(owedMember.getUserName(),
                    paidUserFriendsBalance.getOrDefault(owedMember.getUserName(), 0.0) + owedAmount);

            UserExpenseBalanceSheet owedMemberExpenseBalanceSheet = owedMember.getUserExpenseBalanceSheet();
            owedMemberExpenseBalanceSheet.setTotalOwed(owedMemberExpenseBalanceSheet.getTotalOwed() + owedAmount);
            Map<String, Double> owedMemeberFriendsBalance = owedMemberExpenseBalanceSheet.getFriendsBalance();

            owedMemeberFriendsBalance.put(paidByUser.getUserName(),
                    owedMemeberFriendsBalance.getOrDefault(paidByUser.getUserName(), 0.0) -owedAmount);
        }
    }

    public void printBalanceSheet(UserExpenseBalanceSheet userExpenseBalanceSheet) {

    }
}
