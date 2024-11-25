package booklibrary;

import java.util.Scanner;
import java.util.ArrayList;

public class Admin {
    
    //it will handle a admin menu to user's
    public static void admin(Scanner scan, ArrayList<Book> books, ArrayList<Member> members){
        System.out.print("\nEnter password: ");
        String password = scan.nextLine();
        
        //it will check the input is equal to "admin" it will enter to loop
        if(password.equalsIgnoreCase("admin")){
            
            /* while true for infinite loop to repeatedly show this to user 
            it will end until user select exit */
            while(true){
                System.out.println("\n===============");
                System.out.println("-     Admin's Menu    -");
                System.out.println("===============");
                System.out.println("[1]  - View All Books/Status");
                System.out.println("[2] - View Borrowed Books");
                System.out.println("[3] - View All Members and Information");
                System.out.println("[4] - Back");
                System.out.print("Enter choice: ");
                
                int choice = scan.nextInt();
                scan.nextLine();
                
                //it will handle user's choice
                switch(choice){
                    case 1:
                        Book.showAvailableBooks(books);//Calling method in Book class
                        break;
                    case 2:
                        Book.viewBorrowedBooks(members);//Calling method in Book class
                        break;
                    case 3:
                        Member.showMemberInfo(members, scan);//Calling method in Member class
                        break;
                    case 4:
                        return; //it will exit to the loop
                    default:
                        System.out.println("Sorry, Invalid Choice");//It will display when invalid choice
                }
            }
        } else {
            System.out.println("\nWrong password");//It will display when wrong password
            return;
        }
    }
}