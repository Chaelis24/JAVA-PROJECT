package booklibrary;

import java.util.Scanner;
import java.util.ArrayList;

public class Member{
    
    //attributes for member class
    private String username, password;
    private int age;
    private String name, address, phoneNumber;
    private ArrayList<Book> borrowedBooks;
    
    //Constructor to initialize a new member registration
    public Member(String username, String password, String name, int age, String address, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>(); //inialize arraylist
    }
    
    // it will register membership, it will add to the array list of members
    public static void registeringMember(Scanner scan, ArrayList<Member> members, ArrayList<Book> books){
        System.out.println("\nRegister Membership");
        System.out.print("Username: ");
        String username = scan.nextLine();
        
        System.out.print("Password: ");
        String password = scan.nextLine();
        
        System.out.print("Full Name: ");
        String name = scan.nextLine();
        
        System.out.print("Age: ");
        int age = scan.nextInt();
        scan.nextLine();
        
        System.out.print("Address: ");
        String address = scan.nextLine();
        
        System.out.print("Phone Number: ");
        String phoneNumber = scan.nextLine();
        
        members.add(new Member(username, password, name, age, address, phoneNumber));//Member will add to list
        System.out.println("\nMembership Added Successfully");
        
        while(true){
            System.out.println("\n[1]  - Add Book");
            System.out.println("[2] - Borrow Book");
            System.out.println("[3] - Return Book");
            System.out.println("[4] - View Borrowed Books");
            System.out.println("[5] - View Available Books/Status");
            System.out.println("[6] - View Members List");
            System.out.println("[7] - Back");
            System.out.print("Choose option: ");
            
            int choice = scan.nextInt();
            scan.nextLine();
            
            switch(choice){
                case 1:
                    Book.addBook(scan, books, members);//Calling method in Book class
                    break;
                case 2:
                    Book.borrowBook(books, scan, members);//Calling method in Book class
                    break;
                case 3:
                    Book.returnBook(books, scan, members);//Calling method in Book class
                    break;
                case 4:
                    Book.viewBorrowedBooks(members);//Calling method in Book class
                    break;
                case 5:
                    Book.showAvailableBooks(books);//Calling method in Book class
                    break;
                case 6:
                    Member.showMemberList(members);//Calling method in Member class
                    break;
                case 7:
                    return;//It will return to previous method
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    
    //method that will show the members list
    public static void showMemberList(ArrayList<Member> members) {
        System.out.println("\nList of members");

        for (Member member : members) {
            System.out.println("\n===============");
            System.out.println("Name: " + member.getName());
            System.out.print("Borrowed Books: ");
            if (member.borrowedBooks.isEmpty()) {
                System.out.println("None\n");
            } else {
                for (Book book : member.borrowedBooks) {
                    System.out.println(book.getTitle());
                    System.out.println("When: " + book.getDateOfAdd() + "\n");
                }
            }
            System.out.println("===============");
        }
    }
    //Method that will show the member list information
    public static void showMemberInfo(ArrayList<Member> members, Scanner scan){
        System.out.println(members.size() + " \nMembers Information");
        
        for (Member member : members) {
            System.out.println("\n===============");
            System.out.println("Full Name: " + member.getName());
            System.out.println("Age: " + member.getAge());
            System.out.println("Address: " + member.getAddress());
            System.out.println("Phone Number: " + member.getPhoneNumber());
            
            ArrayList<Book> borrowedBooks = member.getBorrowedBooks();
            if (borrowedBooks.isEmpty()) {
                System.out.println("No books borrowed");
            } else {
                System.out.println("Books Borrowed: ");
                for (Book book : borrowedBooks) {
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Author: " + book.getAuthor());
                }
            }
            System.out.println("===============");
        }
    }
    
    //Method that will find a member name
    public static Member findMember(ArrayList<Member> members, String name) {
        for (Member member : members) {
            if (member.name.equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }
    
    // Add a book to the member's borrowedBooks list
    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);//The book will ads
    }

    // Remove a book from the member's borrowedBooks list
    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);//The book will remove
    }
    
    //getters for a member
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public ArrayList<Book> getBorrowedBooks(){
        return borrowedBooks;
    }
}