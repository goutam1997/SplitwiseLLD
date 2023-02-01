package models;

public class Split {
    private User user;
    private double amountOrPercentageOwed;

    public Split(User user, double amountOrPercentageOwed) {
        this.user = user;
        this.amountOrPercentageOwed = amountOrPercentageOwed;
    }

    public User getUser() {
        return user;
    }

    public double getAmountOrPercentageOwed() {
        return amountOrPercentageOwed;
    }
}
