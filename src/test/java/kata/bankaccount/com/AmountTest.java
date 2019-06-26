package kata.bankaccount.com;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AmountTest {
    @Test
    public void add_amount_to_an_other() throws Exception {
        Amount amount = new Amount(100);
        amount = amount.add(new Amount(100));
        Amount expectedAmount = new Amount(200);
        Assertions.assertThat(amount).isEqualTo(expectedAmount);
    }

    @Test
    public void subtract_amount_to_an_other() throws Exception {
        Amount amount = new Amount(50);
        amount = amount.subtract(new Amount(25));
        Amount expectedAmount = new Amount(25);
        Assertions.assertThat(amount).isEqualTo(expectedAmount);
    }

    @Test
    public void should_return_false_when_the_result_is_negative() throws Exception {
        Amount amount = new Amount(5);
        Assertions.assertThat(amount.canWithdraw(new Amount(5))).isTrue();
    }

    @Test
    public void should_return_true_when_the_result_is_positive() throws Exception {
        Amount amount = new Amount(15);
        Assertions.assertThat(amount.canWithdraw(new Amount(10))).isTrue();
    }
}
