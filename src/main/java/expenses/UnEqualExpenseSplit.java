package expenses;

import exceptions.InvalidUnEqualSplitException;
import models.Split;
import models.User;

import java.util.*;

public class UnEqualExpenseSplit implements ExpenseSplit {
    @Override
    public Map<User, Double> getContributionMap(double amount, List<User> sharedWithMembers, List<Split> splits) {
        Map<User, Double> contributionMap = new HashMap<>();
        double addedAmount = 0.0;
        for (Split split: splits) {
            addedAmount += split.getAmountOrPercentageOwed();
            contributionMap.put(split.getUser(), split.getAmountOrPercentageOwed());
        }
        if (addedAmount != amount) {
            throw new InvalidUnEqualSplitException();
        }
        return contributionMap;
    }
}
