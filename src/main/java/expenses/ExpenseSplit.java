package expenses;

import models.Split;
import models.User;

import java.util.List;
import java.util.Map;

public interface ExpenseSplit {
    Map<User, Double> getContributionMap(double amount, List<User> sharedWithMembers, List<Split> splits);
}
