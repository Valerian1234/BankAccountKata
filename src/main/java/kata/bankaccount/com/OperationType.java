package kata.bankaccount.com;

public enum OperationType {
    DEPOSIT("Deposit "), WITHDRAWAL("Withdraw ");

    private final String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}