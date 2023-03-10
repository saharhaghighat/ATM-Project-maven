package com.none.domain;

import com.none.domain.Enum.AccountType;
import com.none.domain.Enum.TransactionType;
import com.none.exception.InvalidAmountException;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class Account {

    private Integer id;

    private final static Double MIN_BALANCE = 100d;

    private Card card;

    private User user;

    private List<Transaction> transactions;

    private AccountType accountType;

    private String accountNumber;

    private String password;

    private Double balance;

    public Account(User user, AccountType accountType, String password) {
        Random random = new Random();
        this.id = random.nextInt(100);
        this.accountNumber = String.valueOf(random.nextLong(1000000000, 999999999));
        this.user = user;
        this.accountType = accountType;
        this.password = password;
        this.balance = 50d;
        this.card = new Card(password);
    }

    public Account( String accountNumber, String password, Double balance,AccountType accountType) {

        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = balance;
    }

    public Account(String string, String string1, String string2, String string3) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public static Double getMinBalance() {
        return MIN_BALANCE;
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                "name=" + user.getName() + " " + user.getLastName() +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                "}\n";
    }

    public void deposit(Double amount) {
        this.balance += amount;
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount);
        if (Objects.isNull(transactions)) {
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);
    }

    public void withDraw(Double amount) {
        if (amount < this.balance) {
            this.balance = this.balance - amount;
            Transaction transaction = new Transaction(TransactionType.WITHDRAW, amount);
            if (Objects.isNull(transactions))
                transactions = new ArrayList<>();
            transactions.add(transaction);
        } else
            throw new InvalidAmountException();

    }


}
