package expenses;

import constants.ExpenseSplitType;

public class SplitTypeFactory {
    public ExpenseSplit getExpenseSplit(ExpenseSplitType expenseSplitType) {
        if (ExpenseSplitType.EQUAL.equals(expenseSplitType)) {
            return new EqualExpenseSplit();
        }
        if (ExpenseSplitType.UNEQUAL.equals(expenseSplitType)) {
            return new UnEqualExpenseSplit();
        }
        if (ExpenseSplitType.PERCENTAGE.equals(expenseSplitType)) {
            return new PercentageExpenseSplit();
        }
        return null;
    }
}
