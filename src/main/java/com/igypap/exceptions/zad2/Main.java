package com.igypap.exceptions.zad2;

/**
 * Created by igypap on 26.11.16.
 */
public class Main {


    public static void main(String[] args) {
        Person person = new Person("Tomek", "Nowak");
        BankAccount personAccount = new BankAccount("4256870000125698745322", person);
        personAccount.deposit(2500.0);
        System.out.println("Stan twojego konta to: " + personAccount.getFunds());
        try {
            personAccount.withdraw(2600.0);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Stan twojego konta to: " + personAccount.getFunds());

        try {
            personAccount.withdraw(2200.0);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Stan twojego konta to: " + personAccount.getFunds());
    }


}
