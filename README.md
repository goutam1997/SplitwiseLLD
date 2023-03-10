# SplitwiseLLD
#Requirements:
1. User can share expense with another user or in a group.
2. A group must have logs of expenses in it.
3. Main requirement was to have equal split functionality but the design should be extensible to accommodate future split types

#Assumptions:
1. User belongs to the group while adding expense for a group.
2. While sharing expense with friend, user himself/herself is included.

#Design patterns used:
1. Here I used *Composite Design* pattern as expenses can be shared between another user and group. So both are implementing CanShareExpense Interface. In the runtime, appropriate shareExpense() method will be called according to the type of object passed.
2. Also used *Factory Design* pattern to determine the object according to Split type which can be Equal, Unequal or Percentage.