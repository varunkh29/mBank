package com.example.thispc.mbank;

public class TransactionInfo {

    String from, to, amount, date,type,newbal;

    public TransactionInfo(String from, String to, String amount, String date, String type, String newbal) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.newbal = newbal;
    }

    public String getType() {
        return type;
    }

    public String getNewbal() {
        return newbal;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}



