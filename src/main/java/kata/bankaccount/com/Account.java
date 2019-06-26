package kata.bankaccount.com;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static kata.bankaccount.com.OperationType.*;

public class Account {
    private Balance balance;
    private final List<Statement> statements = new ArrayList<>();
    private final LocalDate date;

    public Account(Balance balance, LocalDate date) {
        this.balance = balance;
        this.date = date;
    }

    public void deposit(Amount amount) {

        balance = balance.deposit(amount);
        CreateStatement(amount, DEPOSIT);
    }

    public void withdraw(Amount amount) {
        if(!(balance.canWithdraw(amount))) {
        	throw new IllegalStateException();
        }

        balance = balance.withdraw(amount);
        CreateStatement(amount, WITHDRAWAL);
    }

    public void printAllStatement() {
        for (Statement statement : statements) {
            statement.print();
        }
    }

    private void CreateStatement(Amount amount, OperationType operationType) {
        Statement statement = new Statement(date.now(), amount, balance, operationType);
        statements.add(statement);
    }

    public Balance getBalance() {
        return balance;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}