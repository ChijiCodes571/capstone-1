# Accounting Ledger Application

## About

The Accounting Ledger is a Java command-line application that allows users to manage and track financial transactions.

Users can add deposits, record payments, view their transaction history, and generate reports based on transaction dates or vendors.

## Features

- Add deposits.
- Record payments.
- View all transactions.
- View deposits only.
- View payments only.
- View reports:
    - Month to Date
    - Previous Month
    - Year to Date
    - Previous Year
    - Search by Vendor
- Store transactions in a CSV file.
- Handle invalid amount input.
- Skip malformed transaction rows.

## Prerequisites

To run this application, one will need the following:

- Java Development Kit (JDK) 17 or later.
- IntelliJ IDEA.
- Maven

## How to Run

- Clone or download the repository from GitHub.
- Open the capstone-1 project folder in IntelliJ IDEA.
- Make sure JDK 17 is configured for the project.
- Locate UserInterface.java inside src/main/java/com/pluralsight.
- Right-click UserInterface.java and select Run 'UserInterface.main()'.
- The application menu will appear in the console. 
- Follow the menu instructions to add deposits, make payments, or view the ledger.

## Transaction Data

The application uses a file which is called transactions.csv to store transaction records.

The file is located in the main capstone-1 project folder.

Each transaction is stored using the format that will be shown below:

date|time|description|vendor|amount

Example:

2026-11-03|10:30:00|Lunch|Restaurant|-15.50

## Code I'm Proud of

There are three parts of my project that I am particularly proud of.

The first is my Transaction class. I enjoyed writing the attributes, constructor, and getters because I remember having a lot of trouble understanding how they worked at the beginning. 

As I kept working on the class, I started to understand how everything connected and how the class was used in the rest of my program.

The second part is in my UserInterface class. I am proud of how I used if-else statements to handle the different menu options. 

At one point, I considered using switch statements instead, but I decided to stick with if-else because that was the approach I preferred. 

I also discussed this with my instructor, who explained that I could use whichever approach I was more comfortable with.

I am also proud of how I placed my Scanner in the class instead of declaring a separate scanner inside different methods.

I remember being happy when I figured out how to do that myself instead of only following the approach shown in class.

One way I like to think about methods and variables is through a neighborhood analogy. I imagine methods as neighbors who each have their own houses. 

They do not automatically know what is happening inside each other's houses. 

However, the class is like someone walking down the street who can see into the houses when the windows are open. 

This is how I remember that local variables belong to their methods, while variables declared at the class level can be accessed by different methods in that class.

One thing I learned from this experience is that there can be different ways to solve the same problem. 

You can choose the approach that works best for you, as long as it does what the program needs to do.

I also learned that understanding something takes time and practice. 

Even when I struggled with the Transaction class, I kept working on it until I understood it better.

### Transaction Class

```java
package com.pluralsight;

public class Transaction {
    // attributes
    private String date;
    private String time;
    private String description;
    private String vendor;
    private String amount;

    // constructor
    Transaction(String date, String time, String description, String vendor, String amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // Getters
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public String getAmount() {
        return amount;
    }

    // Display method
    public void display() {
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Description: " + description);
        System.out.println("Vendor: " + vendor);
        System.out.println("Amount: " + amount);
    }
}```
- This class is responsible for storing the information for each transaction. 
- I used private attributes to hold the transaction details, a constructor to initialize them, and getters to access the information. 
- I also created a display method to print the transaction details.


## Development Process

One of the biggest challenges I faced while building this project was dealing with impostor syndrome. At the beginning, I sometimes doubted myself and my ability to understand Java.

The project started off fairly well because the first parts were simple. 

However, as I started adding more methods, while loops, if statements, and try-catch blocks, things became more challenging. 

Try-catch was especially difficult for me to understand, and I sometimes felt unsure about what I was doing.

I also had moments where I forgot things I had already learned, such as how to use substring() or .length() to work with strings. 

Sometimes, I even forgot why I had written certain pieces of code. 

This made me realize how helpful comments can be when explaining why I wrote something a particular way.

I used NinJava to help me understand certain concepts and break down problems into smaller steps. 

It helped me work through things I was struggling with instead of giving up.

Another challenge was simply sitting down and facing my laptop, trying to figure out how to make everything work together. 

There were moments when I felt stuck, but I kept working through the problems.

Overall, this project taught me that learning to code takes patience and practice. 

It is okay to forget things or struggle with a concept.

What matters is being willing to go back, learn, ask questions and keep trying.

I started by creating the Transaction class and setting up the basic menus. 

After that, I worked on adding deposits and payments, displaying transactions, filtering the ledger, and creating the reports menu. 

I also added input validation and handling for malformed transaction records.