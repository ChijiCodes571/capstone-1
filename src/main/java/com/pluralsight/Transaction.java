package com.pluralsight;

public class Transaction {
    //attributes

    private String date;
    private String time;
    private String description;
    private String vendor;
    private String amount;

    //constructor

    Transaction (String date, String time, String description, String vendor, String amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

        // toString method

        @Override
        public String toString() {
            return "Transaction{" +
                    "date='" + date + '\'' +
                    ", time='" + time + '\'' +
                    ", description='" + description + '\'' +
                    ", vendor='" + vendor + '\'' +
                    ", amount='" + amount + '\'' +
                    '}';




        }



}

