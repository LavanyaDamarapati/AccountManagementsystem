package com.ams.accountmanagementsystem.model;

public class UserResponse {
    private String name;
    private String surname;
    private double balance;
    private Transaction transaction;

    public UserResponse(String name, String surname, double balance, Transaction transaction) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.transaction = transaction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}