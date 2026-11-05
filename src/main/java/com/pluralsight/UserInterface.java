package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        String response = " ";

        do {
            System.out.println("""
                    Choose the following option: 
                    Add Deposit (D)
                    Make Payment (P)
                    Ledger (L)
                    Exit (X)
                    """);

            response = scanner.nextLine().toUpperCase();

            if (response.equals("D")) {
                addTransaction("D");

            } else if (response.equals("P")) {
                addTransaction("P");
            } else if (response.equals("L")) {
                displayLedgerMenu();
            } else if (response.equals("X")) {
                System.out.println("Exit application");
            } else {
                System.out.println("Invalid response");
            }
        } while (!response.equals("X"));

    }

    // Method for ledger screen

    public static void displayLedgerMenu () {

        String reply = " ";

        do{
            System.out.println("""
                    Choose any option you want: 
                    All (A)
                    Deposits (D)
                    Payments (P)
                    Reports (R)
                    go back to home page(H)
                    """);

            reply = scanner.nextLine().toUpperCase();

            if(reply.equals("A")){
                readTransaction("A");
            }
            else if (reply.equals("D")) {
                readTransaction("D");
            }
            else if (reply.equals("P")) {
                readTransaction("P");
            }
            else if (reply.equals("R")) {
                displayReport();
            }
            else if (reply.equals("H")) {
                System.out.println("go back to the home page");
            }
            else{
                System.out.println("Invalid Reply");
            }

        }while(!reply.equals("H"));

    }

    // Report screen

    public static void displayReport () {

        int num = -1;

        do{
            System.out.println("""
                    Enter a number of your choice: 
                    Month to Date (1)
                    Previous Month (2)
                    Year to Date (3)
                    Previous Year (4)
                    Search by Vendor (5)
                    Back (0)
                    """);

            String input = scanner.nextLine().trim();
            try{
                num = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number");
                continue;
            }

            if(num == 1){
                System.out.println("Displaying Months to Date");
            }
            else if ( num == 2){
                System.out.println("Displaying Previous Month");
            }
            else if ( num == 3){
                System.out.println("Displaying Year to Date");
            }
            else if ( num == 4){
                System.out.println("Displaying Previous Year...");
            }
            else if ( num == 5){
                System.out.println("Search by Vendor...");
            }
            else if ( num == 0){
                //Return to Ledger
            }
            else {
                System.out.println("Invalid number");
            }
        }while(num != 0);
    }

    // Transaction CSV

    public static void readTransaction (String type) {
        File file = new File("transactions.csv");

        try{
            Scanner fileScanner = new Scanner(file);
            ArrayList<Transaction> transactions = new ArrayList<>();

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if(line.startsWith("date")){
                    continue;
                }
                String[] transactionDate = line.split("\\|");

                if(transactionDate.length < 5) {
                    System.out.println("Invalid transaction row. Skipping...");
                    continue;
                }

                Transaction transaction = new Transaction(
                        transactionDate[0],
                        transactionDate[1],
                        transactionDate[2],
                        transactionDate[3],
                        transactionDate[4]
                );

                double amount;
                try{
                    amount = Double.parseDouble(transaction.getAmount());
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid transaction amount. Skipping...");
                    continue;
                }


                if(type.equals("A")) {
                    transactions.add(transaction);
                }
                else if (type.equals("D") && amount > 0){
                    transactions.add(transaction);
                }
                else if (type.equals("P") && amount < 0) {
                   transactions.add(transaction);
                }

            }
            for (int i = 0; i < transactions.size(); i++) {
                for (int j = i + 1; j < transactions.size(); j++) {
                    Transaction first = transactions.get(i);
                    Transaction second = transactions.get(j);

                    String firstYear = first.getDate().substring(0,4);
                    String secondYear = second.getDate().substring(0,4);

                    String firstMonth = first.getDate().substring(5,7);
                    String secondMonth = second.getDate().substring(5,7);

                    String firstDay = first.getDate().substring(8,10);
                    String secondDay = second.getDate().substring(8,10);

                    int year1 = Integer.parseInt(firstYear);
                    int year2 = Integer.parseInt(secondYear);

                    int month1 = Integer.parseInt(firstMonth);
                    int month2 = Integer.parseInt(secondMonth);

                    int day1 = Integer.parseInt(firstDay);
                    int day2 = Integer.parseInt(secondDay);

                    boolean itSwaps = false;

                    if(year1 < year2){
                        itSwaps = true;
                    }

                    else if (year1 == year2 && month1 < month2){
                        itSwaps = true;
                    }
                    else if (year1 == year2 && month1 == month2 && day1 < day2){
                        itSwaps = true;
                    }

                    if(itSwaps) {
                        Transaction temp = first;
                        first = second;
                        second = temp;

                        transactions.set(i, first);
                        transactions.set(j, second);
                    }
                }

            }
            for(Transaction transaction : transactions){
                transaction.display();
            }
            fileScanner.close();


        }catch (FileNotFoundException e){
            System.out.println(("file not found"));
        }
    }

    //Adding Transaction

    public static void addTransaction(String type) {

        System.out.print("Enter time: ");
        String time = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter name of vendor: ");
        String vendor = scanner.nextLine();

        boolean validDateFormat = false;
        String date = "";

        while (!validDateFormat) {
            System.out.println("Enter date: ");
            date = scanner.nextLine();

            if (date.length() == 10 &&
                    date.substring(4, 5).equals("-") &&
                    date.substring(7, 8).equals("-")) {

                validDateFormat = true;

            } else {
                System.out.println("Invalid date. Use yyyy-MM-dd.");
            }
        }

        double amount = 0;
        boolean correctAmount = false;

        while(!correctAmount){
            System.out.println("Enter amount: ");

            try{
                amount = Double.parseDouble(scanner.nextLine());
                if (amount == 0){
                    System.out.println("Amount cannot be zero.");
                }
                else{
                    correctAmount = true;
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid number.");
            }
        }

        if(type.equals("P")){
            amount = amount * -1;
        }


        File file = new File("transactions.csv");

        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write (date + "|" + time + "|" + description + "|" + vendor + "|" + amount + "\n");

            writer.close();

            System.out.println("Transaction has been saved sucessfully");
        } catch (IOException e){
            System.out.println("There was an error writing file.");
        }


    }



}
