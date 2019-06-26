package kata.bankaccount.com;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class AccountTest {
    private Account account;
    private LocalDate dateService = LocalDate.now();

    // Setting up the balance
    @Before
    public void setUp() throws Exception {
        account = new Account(new Balance(new Amount(30)) , dateService);
    }

    // Deposit Test
    @Test
    public void should_add_right_amount() throws Exception {
        account.deposit(new Amount(20));
        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(50)));
    }

    @Test
    public void should_adding_zero_to_my_account() throws Exception {
        account.deposit(new Amount(0));
        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(30)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_authorize_deposit_negative_value() throws Exception {
        account.deposit(new Amount(-10));
    }


    // Withdraw Test

    @Test
    public void should_subtract_zero_to_my_account() throws Exception {
        account.withdraw(new Amount(0));
        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(30)));
    }

    @Test
    public void should_subtract_right_amount() throws Exception {
        account.withdraw(new Amount(20));
        Assertions.assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(10)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_authorize_withdrawal_negative_value() throws Exception {
        account.withdraw(new Amount(-10));
    }

    @Test(expected = IllegalStateException.class)
    public void should_not_authorize_withdrawal_an_amount_which_is_not_present_in_an_account() throws Exception {
        account.withdraw(new Amount(40));
    }
}
