package com.none.domain;


import com.none.domain.Enum.TransactionType;

import java.util.Date;

public class Transaction {
    private long id;

    private TransactionType transactionType;

    private Double amount;

    private Date date;

    public Transaction(TransactionType transactionType, Double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "transactionType=" + transactionType +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
