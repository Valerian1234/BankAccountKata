package kata.bankaccount.com;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BalanceTest {

    @Test
    public void should_adding_ten_to_my_balance() throws Exception {
        Balance balance = new Balance(new Amount(0));
        balance = balance.deposit(new Amount(10));
        Balance expectedBalance = new Balance(new Amount(10));
        Assertions.assertThat(balance).isEqualTo(expectedBalance);
    }

    @Test
    public void should_subtract_five_to_my_balance() throws Exception {
        Balance balance = new Balance(new Amount(20));
        balance = balance.withdraw(new Amount(5));
        Balance expectedBalance = new Balance(new Amount(15));
        Assertions.assertThat(balance).isEqualTo(expectedBalance);
    }

    @Test
    public void should_return_false_when_the_result_is_negative() throws Exception {
        Balance balance = new Balance(new Amount(10));
        boolean isWithDrawNegative = balance.canWithdraw(new Amount(20));
        Assertions.assertThat(isWithDrawNegative).isFalse();
    }

    @Test
    public void should_return_true_when_the_result_is_positive() throws Exception {
        Balance balance = new Balance(new Amount(10));
        boolean isWithDrawPositive = balance.canWithdraw(new Amount(5));
        Assertions.assertThat(isWithDrawPositive).isTrue();
    }
}
