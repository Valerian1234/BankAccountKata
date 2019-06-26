package kata.bankaccount.com;

public class Balance {
    private final Amount amount;

    public Balance(Amount amount) {
        this.amount = amount;
    }
    
    public Balance() {
    	this.amount = new Amount(0);
    }

    public Balance deposit(Amount amount) {
        return new Balance(this.amount.add(amount));
    }

    public Balance withdraw(Amount amount) {
        return new Balance(this.amount.subtract(amount));
    }
    
    public boolean canWithdraw(Amount amount) {
        return this.amount.canWithdraw(amount);
    }

    @Override
    public boolean equals(Object o) {
    	// check if they are the same object
        if (this == o) {
        	return true;
        } else if (!(o instanceof Balance)) { // check if o is an instance of Balance or one of its subclasses
        	return false;
        }

        Balance balance = (Balance) o;
        
        if(amount != null) { // as they are of same class we can compare with equals
        	return amount.equals(balance.amount);
        } else { // if amount is null then we can compare it to o's balance by comparing it with null
        	return balance.amount == null;
        }
    }

    @Override
    public String toString() {
        return "Your balance is " + amount;
    }
}
