package booklibrary;

import java.util.Scanner;
import java.util.ArrayList;

public class User{
    
    public static void user(Scanner scan, ArrayList<Member> members, ArrayList<Book> books){
        /**
         * while true for infinite loop to repeatedly show this to user
         * it will end until user select exit
         */
        while(true){
            System.out.println("\n===============");
            System.out.println("-      User's Menu     -");
            System.out.println("===============");
            System.out.println("[1]  - Login Account");
            System.out.println("[2] - Register Membership");
            System.out.println("[3] - Back");
            
            System.out.print("Choose option: ");
            int choice = scan.nextInt();
            scan.nextLine();
            
            //it will handle user's choice
            switch(choice){
                case 1:
                    User.loginAcc(scan, books, members);//Calling method in it's class
                    break;
                case 2:
                    Member.registeringMember(scan, members, books);//Calling method in Member clas
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    
    //this method handle a user loging account
    public static void loginAcc(Scanner scan, ArrayList<Book> books, ArrayList<Member> members) {
         System.out.println("\nLogin Your Account\n");
         System.out.print("Enter your username: ");
         String username = scan.nextLine();
         System.out.print("Enter your password: ");
         String password = scan.nextLine();
         
         boolean loggedIn = false; //set to false to assume that not log in
         
        //for each loop to find the members and it match to username & password
         for(Member member : members){
             if(username.equalsIgnoreCase(member.getUsername()) && password.equalsIgnoreCase(member.getPassword())){
                 loggedIn = true; //set to true if user has been logged in
                 System.out.println("\nLogged In Successfully");
                 System.out.println("Welcome, " + member.getName());
                 
                 /* while true for infinite loop to repeatedly show this to user 
                 it will end until user select exit */
                 while(true){
                     System.out.println("\n[1]  - Add Book");
                     System.out.println("[2] - Borrow Book");
                     System.out.println("[3] - Return Book");
                     System.out.println("[4] - View Borrowed Books");
                     System.out.println("[5] - View Available Books/Status");
                     System.out.println("[6] - View Member List");
                     System.out.println("[7] - Back");
                     System.out.print("Choose option: ");
                     int choice = scan.nextInt();
                     scan.nextLine();
                     
                     //it will handle a user's choice
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
                            return; //it will back to recent method
                        default:
                            System.out.println("Invalid Choice"); //when user choose an invalid choice it will display
                    }
                 }
             }
         }
        //if login is fails, it will show to user that invalid username or password
         if (!loggedIn) {
             System.out.println("\nSorry, wrong username or password");
         }
     }
}