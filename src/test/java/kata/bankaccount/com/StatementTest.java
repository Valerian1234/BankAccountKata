package kata.bankaccount.com;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class StatementTest {


    @Test
    public void should_print_all_statement() {
        Balance balance = new Balance(new Amount(50));
        Account account = new Account(balance, LocalDate.now());
        account.deposit(new Amount(100));
        account.withdraw(new Amount(25));
        List<Statement> statements = account.getStatements();
        Assert.assertEquals(statements.toString(), ("[" + LocalDate.now() + " | Deposit 100 | Your balance is 150" + ", " + LocalDate.now() + " | Withdraw 25 | Your balance is 125]"));
    }
}
