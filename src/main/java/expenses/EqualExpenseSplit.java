package expenses;

import models.Split;
import models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualExpenseSplit implements ExpenseSplit {
    @Override
    public Map<User, Double> getContributionMap(double amount, List<User> sharedWithMembers, List<Split> splits) {
        int memberCount = sharedWithMembers.size();
        Map<User, Double> contributionMap = new HashMap<>();
        for (User user: sharedWithMembers) {
            contributionMap.put(user, amount/memberCount);
        }
        return contributionMap;
    }
}
