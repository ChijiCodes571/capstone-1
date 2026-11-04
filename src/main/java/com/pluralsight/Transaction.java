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

    // Getters
    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }

    public String getDescription(){
        return description;
    }

    public String getVendor(){
        return vendor;
    }

    public String getAmount(){
        return amount;
    }

    // Display method
    public void display(){
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Description: " + description);
        System.out.println("Vendor: " + vendor);
        System.out.println("Amount: " + amount);
    }











}

