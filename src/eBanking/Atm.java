package eBanking;

import java.util.Scanner;

public class Atm {
    private static Scanner scanner = new Scanner(System.in);
    private static  Bank zuBank = new Bank("zuBank,", 20);
    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        String prompt = """
                Welcome to ZuBank,
                Press softly
                1. -> To create account.
                2. -> To deposit.
                3. -> To withdraw.
                4. -> To Transfer.
                5. -> To check balance.
                6. -> To exit.
                """;
        System.out.println(prompt);
        String userResponse = scanner.nextLine();
        switch (userResponse) {
            case "1" -> createAccount();
            case "2" -> putMoney();
            case "3" -> commotMoney();
            case "4" -> sendUrgent2k();
            case "5" -> checkBalance();
            case "6" -> exit();
            default -> runApp();
        }
    }

    private static void exit() {
        System.out.println("Thank you for banking with us");
        System.exit(0);
    }

    private static void checkBalance() {
        System.out.println("Enter account number");
        String accountNumber = scanner.nextLine();

        System.out.println("Your pin");
        String pin = scanner.next();
        Account account = zuBank.findAccount(Integer.parseInt(accountNumber));
        System.out.println("Your balance is: " + account.getBalance(pin));
        scanner.next();
        runApp();
    }

    private static void sendUrgent2k() {
        System.out.println("Enter account number: ");
        String senderAccountNumber = scanner.nextLine();


        System.out.println("Enter receivers account");
        String receiverAccountNumber = scanner.nextLine();


        System.out.println("Enter pin: ");
        String pin = scanner.nextLine();

        System.out.println("How much: ");
        int amount = scanner.nextInt();

        zuBank.transfer(amount, senderAccountNumber, receiverAccountNumber, pin);
        Account fromAccount = zuBank.findAccount(Integer.parseInt(senderAccountNumber));

        System.out.println("Your new balance is " + fromAccount.getBalance(pin));
        scanner.next();
        runApp();

    }

    private static void commotMoney() {
        System.out.println("Which account: ");
        String accountNumber = scanner.nextLine();


        System.out.println("Enter pin");
        String pin = scanner.nextLine();


        System.out.println("How much: ");
        int amount = scanner.nextInt();

        zuBank.withdraw(amount, accountNumber, pin);

        System.out.println("successful!!!");
        Account account = zuBank.findAccount(Integer.parseInt(accountNumber));
        System.out.println();
        System.out.println("New balance is " + account.getBalance(pin));
        System.out.println();

        scanner.next();
        runApp();
    }

    private static void putMoney() {
        System.out.println("Which account: ");
        String accountNumber = scanner.nextLine();

        Account account = zuBank.findAccount(Integer.parseInt(accountNumber));
        System.out.println("The account name is " + account.getFullName());

        System.out.println("How much: ");
        int amount = scanner.nextInt();

        zuBank.deposit(amount, accountNumber);

        System.out.println();
        System.out.println(account);
        System.out.println();
        scanner.next();
        runApp();
    }

    private static void createAccount() {
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();


        System.out.println("Enter your surname: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter pin: ");
        String pin = scanner.nextLine();

        System.out.println();
        System.out.println();

        Account savedAccount = zuBank.createAccountFor(firstName, lastName, pin);
        System.out.println(savedAccount);
        System.out.println();
        System.out.println();
        runApp();
    }
}
