package com.igypap.exceptions.zad2;

/**
 * Created by igypap on 26.11.16.
 */
public class BankAccount {
    private String accountNumber;
    private Person owner;
    private double funds;

    public BankAccount(String accountNumber, Person owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
    }

    public double getFunds() {
        return funds;
    }

    public void deposit(double ammount) {
        this.funds += ammount;
    }

    public void withdraw(double ammount) throws InsufficientFundsException {
        if (ammount > this.funds) {
            throw new InsufficientFundsException("Brak środków na koncie");
        } else {
            this.funds -= ammount;
        }
    }


}
