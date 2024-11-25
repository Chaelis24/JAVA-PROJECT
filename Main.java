package booklibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    //Initializing new objects
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();
    
    public static void main(String[] args){
        System.out.println("========================");
        System.out.println(" -  Library System Management - \n -    of Top Link Global College    - ");
        System.out.println("========================");
        
        /* while true for infinite loop to repeatedly show this to user 
        it will end until user select exit */
        while(true){
            System.out.println("\n===============");
            System.out.println("-       Main Menu       -");
            System.out.println("===============");
            System.out.println("[1]  - Admin");
            System.out.println("[2] - User");
            System.out.println("[3] - Exit");
            System.out.print("Enter Choice: ");

            int choice = scan.nextInt();
            scan.nextLine();
            
            switch(choice){
                case 1:
                    Admin.admin(scan, books, members);//Calling method in Admin class.
                    break;
                case 2:
                    User.user(scan, members, books);//Calling method in User class.
                    break;
                case 3:
                    System.out.println("\nSuccessfully Exit....");//It will prompt when successfully exit.
                    return;
                default:
                    System.out.println("Invalid Choice");//It will display when invalid choice
            }
        }
    }
}
