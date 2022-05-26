package eBanking;

public class Bank {
    private final String name;
    private Account[] accounts;
    private int numberOfCustomer;

    public Bank(String bankName, int numberOfCustomer){
        name = bankName;
        accounts = new Account[numberOfCustomer];
    }

    public String getName() {
        return name;
    }

    public int getMaximumNoOfCustomers() {
        return accounts.length;
    }

    public Account createAccountFor(String firstName, String lastName, String pin) {
        String accountNumber = (numberOfCustomer + 1)+"";
        Account account = new Account(accountNumber, firstName, lastName, pin);
        accounts[numberOfCustomer] = account;
        numberOfCustomer++;
        return account;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomer;
    }

    public Account findAccount(int accountNumber) {
        return accounts[accountNumber - 1];
    }

    public void deposit(int amount, String accountNumber) {
        Account account = findAccount(Integer.parseInt(accountNumber));
        account.deposit(amount);
    }

    public void withdraw(int amount, String accountNumber, String pin) {
        Account account = findAccount(Integer.parseInt(accountNumber));
        account.withdrawal(amount, pin);
    }

    public void transfer(int amount, String from, String to, String sendersPin) {
        Account senderAccount = findAccount(Integer.parseInt(from));
        Account receiverAccount = findAccount(Integer.parseInt(to));
        senderAccount.withdrawal(amount, sendersPin);
        receiverAccount.deposit(amount);
    }
}

