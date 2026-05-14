package com.library;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    static ArrayList<String> books = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        books.add("Java");
        books.add("Python");
        books.add("DevOps");

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Display Books");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                    displayBooks();
                    break;

                case 2:
                    System.out.print("Enter Book Name: ");
                    String newBook = sc.nextLine();
                    books.add(newBook);
                    System.out.println("Book Added Successfully");
                    break;

                case 3:
                    System.out.print("Enter Book Name to Issue: ");
                    String issueBook = sc.nextLine();

                    if(books.contains(issueBook)) {
                        books.remove(issueBook);
                        System.out.println("Book Issued Successfully");
                    } else {
                        System.out.println("Book Not Available");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book Name to Return: ");
                    String returnBook = sc.nextLine();

                    books.add(returnBook);
                    System.out.println("Book Returned Successfully");
                    break;

                case 5:
                    System.out.println("Exiting Application...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while(choice != 5);

        sc.close();
    }

    static void displayBooks() {

        System.out.println("\nAvailable Books:");

        for(String book : books) {
            System.out.println(book);
        }
    }
}
