package models;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    private Map<String, Double> friendsBalance = new HashMap<>();
    private Map<String, Double> friendToFriendTxn;

    private double totalPaid;
    private double totalBalance;
    private double totalOwed;
    private double totalGetBack;

    public Map<String, Double> getFriendsBalance() {
        return friendsBalance;
    }

    public void setFriendsBalance(Map<String, Double> friendsBalance) {
        this.friendsBalance = friendsBalance;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public double getTotalOwed() {
        return totalOwed;
    }

    public void setTotalOwed(double totalOwed) {
        this.totalOwed = totalOwed;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }

    @Override
    public String toString() {
        return "UserExpenseBalanceSheet{" +
                "friendsBalance=" + friendsBalance +
                ", totalPaid=" + totalPaid +
                ", totalBalance=" + (totalGetBack - totalOwed) +
                ", totalOwed=" + totalOwed +
                ", totalGetBack=" + totalGetBack +
                '}';
    }
}
