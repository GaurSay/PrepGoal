package Design_patterns.Structural.Adapater_Pattern;

public class YesBankAPIAdapter implements BankAPIAdapter {
    private YesBankAPI yesBankAPI = new YesBankAPI();

    @Override
    public double getBalance(String accountNumber) {
        return yesBankAPI.getBalance(accountNumber);
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        return yesBankAPI.sendMoney(fromAccount,toAccount,amount);
    }
}
