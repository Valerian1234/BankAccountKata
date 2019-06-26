package kata.bankaccount.com;

import java.time.LocalDate;

public class Statement {
    private final LocalDate localDate;
    private final Amount amount;
    private final Balance currentBalance;
    private final OperationType operationType;

    public Statement(LocalDate localDate, Amount amount, Balance currentBalance, OperationType operationType) {
        this.localDate = localDate;
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.operationType = operationType;
    }

    public void print() {
        System.out.println(this.toString());
    }


    @Override
    public String toString() {
        return localDate +
                " | " + operationType.getOperation() + amount +
                " | " + currentBalance;
    }
}
