package booklibrary;

import java.util.Scanner;
import java.util.ArrayList;

public class Book {
    
    // Attributes of the class
    private String title, author;
    private String ISBN;
    private String publishDate;
    private String dateOfAdd; //Date when the book was borrowed
    private boolean isBookAvailable; //Available status of book
    private String borrowerName; //Name of user who borrow the book

    // Constructor to initialize a new book with this details need
    public Book(String title, String author, String ISBN, String publishDate) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.isBookAvailable = true; // Book is initially available
        this.borrowerName = null;
    }

    // Method, that can add a new book to a Library
    public static void addBook(Scanner scan, ArrayList<Book> books, ArrayList<Member> members) {
        System.out.println("\nAdding Books");
        System.out.print("Enter book title: ");
        String title = scan.nextLine();
        System.out.print("Enter the author of book: ");
        String author = scan.nextLine();
        System.out.print("Enter ISBN of book: ");
        String ISBN = scan.nextLine();
        System.out.print("Enter publish date: ");
        String publishDate = scan.nextLine();

        books.add(new Book(title, author, ISBN, publishDate)); //it will store value in array list
        
        //It will display the book details after created
        System.out.println("\nBook Successfully Added");
        System.out.println("===============");
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN  : " + ISBN);
        System.out.println("Date Published: " + publishDate);
        System.out.println("\n===============");
    }

    // Method, that will allow to borrow a book
    public static void borrowBook(ArrayList<Book> books, Scanner scan, ArrayList<Member> members) {
        System.out.println("\nBorrowing Books");
        System.out.print("Enter member name: ");
        String memberName = scan.nextLine();
        Member member = Member.findMember(members, memberName);
    
        if (member != null) {
            System.out.print("Enter date of borrow: "); //Enter a date
            String dateOfAdd = scan.nextLine();
            System.out.print("Enter book title to borrow: ");
            String bookTitle = scan.nextLine();
    
            //It will find the book title, that match in stored value
            Book book = findBook(books, bookTitle);
    
            if (book != null && book.isBookAvailable()) {
                book.borrow(dateOfAdd, memberName); //It will update the book status
                member.addBorrowedBook(book); // Add book to member's borrowed list
                System.out.println("\nThe book '" + bookTitle + "' has been borrowed by " + member.getName() + " on " + book.getDateOfAdd());
            } else if (book != null && !book.isBookAvailable()) {
                System.out.println("\nThe book '" + bookTitle + "' is already borrowed by " + book.getBorrowerName() + ".");
            } else {
                System.out.println("\nThe book '" + bookTitle + "' is not found in the catalog.");
            }
        } else {
            System.out.println("\nMember not found.");
        }
    }
    
    //It will update when the book has been borrowed
    public void borrow(String date, String memberName) {
        isBookAvailable = false; // Set to false as the book is now borrowed
        dateOfAdd = date; //Date when they borrow
        borrowerName = memberName; //Borrower name 
    }

    // Method, that will allow to return a book
    public static void returnBook(ArrayList<Book> books, Scanner scan, ArrayList<Member> members) {
        System.out.println("\nReturning Books");
        System.out.print("Enter member name: ");
        String memberName = scan.nextLine();
        
        Member member = Member.findMember(members, memberName);//It will find the member in array list
    
        if (member != null) {
            System.out.print("Enter book title to return: ");
            String bookTitle = scan.nextLine();
            Book book = findBook(books, bookTitle);//It will find the book in array list
    
            if (book != null && !book.isBookAvailable()) {
                book.returnBook();//The book has been returned
                member.removeBorrowedBook(book); // Remove book from member's borrowed list
                System.out.println("\nThe book '" + bookTitle + "' has been returned by " + member.getName());
            } else if (book != null && book.isBookAvailable()) {
                System.out.println("\nThe book '" + bookTitle + "' was not borrowed.");
            } else {
                System.out.println("\nThe book '" + bookTitle + "' is not found.");
            }
        } else {
            System.out.println("\nMember not found.");
        }
    }

    //Method that will update when book returned
    public void returnBook() {
        isBookAvailable = true; // Set to true as the book is now available
        dateOfAdd = null;
        borrowerName = null;
    }
    
    //method that will show the all borrowed books
    public static void viewBorrowedBooks(ArrayList<Member> members) {
        System.out.println("\nBorrowed Books\n");
        boolean found = false;
        
        for (Member member : members) {
            if (!member.getBorrowedBooks().isEmpty()) {
                found = true;
                System.out.println("Member Name: " + member.getName());
                for (Book book : member.getBorrowedBooks()) {
                    System.out.println("  - Title: " + book.getTitle());
                    System.out.println("  - Author: " + book.getAuthor());
                    System.out.println(" ");
                }
                System.out.println("----------------------");
            }
        }
    
        if (!found) {
            System.out.println("\nNo books are currently borrowed.");
        }
    }

    // Show all available books
    public static void showAvailableBooks(ArrayList<Book> books){
        System.out.println("\nList of " + books.size() + " Books");

        for (Book book : books) {
            System.out.println("\n===============");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Date Published: " + book.getPublishDate());

            if (book.isBookAvailable()) {
                System.out.println("Status: Available");
            } else {
                System.out.println("Status: Borrowed by " + book.getBorrowerName());
                System.out.println("When: " + book.getDateOfAdd());
            }
            System.out.println("===============");
        }
    }

    //Method that will find a book title
    public static Book findBook(ArrayList<Book> books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
    // Getters for a book class
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getDateOfAdd() {
        return dateOfAdd;
    }

    public boolean isBookAvailable() {
        return isBookAvailable;
    }

    public String getBorrowerName() {
        return borrowerName;
    }
}