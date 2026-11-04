package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
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
                System.out.println("Add your deposit information: ");

            } else if (response.equals("P")) {
                System.out.println("Add debit information");
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
                    transaction.display();
                }
                else if (type.equals("D") && amount > 0){
                    transaction.display();
                }
                else if (type.equals("P") && amount < 0) {
                   transaction.display();
                }
            }

            fileScanner.close();

        }catch (FileNotFoundException e){
            System.out.println(("file not found"));
        }
    }



}
