package com.pluralsight;

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

    // Method for edger screen

    public static void displayLedgerMenu () {

        String reply = " ";

        do{
            System.out.println("""
                    Choose any option you want: 
                    All (A)
                    Deposits (D)
                    Payments (P)
                    Reports (R)
                    """);

            reply = scanner.nextLine().toUpperCase();

            if(reply.equals("A")){
                // Display all entries
            }
            else if (reply.equals("D")) {
                //Display only the entries that are deposit into the account
            }
            else if (reply.equals("P")) {
                //Display only the negative entries(or payments)
            }
            else if (reply.equals("R")) {
                displayReport();
            }
            else if (reply.equals("H")) {
                //go back to the home page
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
                //
            }
            else if ( num == 2){
                //
            }
            else if ( num == 3){
                //
            }
            else if ( num == 4){

            }
            else if ( num == 5){

            }
            else if ( num == 0){

            }
            else {
                System.out.println("Invalid number");
            }
        }while(num != 0);
    }



}
