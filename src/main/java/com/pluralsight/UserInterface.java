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
                // A new screen that allows the user to run pre-defined reports or to run a custom search
            }
            else if (reply.equals("H")) {
                //go back to the home page
            }
            else{
                System.out.println("Invalid Reply");
            }

        }while(!reply.equals("H"));

    }




}
