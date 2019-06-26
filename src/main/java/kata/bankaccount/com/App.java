package kata.bankaccount.com;


import java.time.LocalDate;

public class App
{
    public static void main( String[] args )
    {
        /*
        Account creation
         */
        Amount amount = new Amount(0);
        Balance balance = new Balance(amount);
        LocalDate date = LocalDate.now();
        Account account = new Account(balance, date);

        /*
        Examples
         */
        System.out.println(account.getBalance());

        Amount amountToDeposit = new Amount(200);
        System.out.println("Deposit of " + amountToDeposit);
        account.deposit(amountToDeposit);
        System.out.println(account.getBalance());

        Amount amountToWithdraw = new Amount(100);
        System.out.println("Withdraw of " + amountToWithdraw);
        account.withdraw(amountToWithdraw);
        System.out.println(account.getBalance());
        account.printAllStatement();
    }
}

// Amount and Balance purposes: to control the type of what we operate with
