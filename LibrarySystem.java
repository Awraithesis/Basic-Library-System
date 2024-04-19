package mainwk2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Mainwk2 {
    private static Map<String, Integer> library = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//use boolean while condition to establish 4 sections of prompts
        while (true) {
            System.out.println("\nLibrary System");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Please enter your selection: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  
//develop output for 3 proper entries that terminate, exiting(#4), or error upon invalid entry
            switch (choice) {
                case 1:
                    addBooks(scanner);
                    break;
                case 2:
                    borrowBooks(scanner);
                    break;
                case 3:
                    returnBooks(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Error, invalid entry. Please enter a number between 1 and 4.");
            }
        }
    }
// 3x secondary prompts for choice of "add books" #1
    private static void addBooks(Scanner scanner) {
        System.out.println("\nAdd Books");

        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the author: ");
        String author = scanner.nextLine();

        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  

        if (library.containsKey(title)) {
            int currentQuantity = library.get(title);
            library.put(title, currentQuantity + quantity);
            System.out.println("Quantity updated for " + title);
        } else {
            library.put(title, quantity);
            System.out.println("New book added: " + title);
        }
    }
// 2x secondary prompts for choice of "borrow books" #2
    private static void borrowBooks(Scanner scanner) {
        System.out.println("\nBorrow Books");

        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();

        if (library.containsKey(title)) {
            System.out.print("Enter the number of books to borrow: ");
            int quantityToBorrow = scanner.nextInt();
            scanner.nextLine();  

            int availableQuantity = library.get(title);
            if (availableQuantity >= quantityToBorrow) {
                library.put(title, availableQuantity - quantityToBorrow);
                System.out.println(quantityToBorrow + " books of " + title + " borrowed successfully.");
            } else {
                System.out.println("Incorrect quantity of " + title + " available.");
            }
        } else {
            System.out.println("Book not found in the library.");
        }
    }
// 2x secondary prompts for choice "return books" #3
    private static void returnBooks(Scanner scanner) {
        System.out.println("\nReturn Books");

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        if (library.containsKey(title)) {
            System.out.print("Enter number of books to return: ");
            int quantityToReturn = scanner.nextInt();
            scanner.nextLine();  

            int currentQuantity = library.get(title);
            library.put(title, currentQuantity + quantityToReturn);
            System.out.println(quantityToReturn + " books of " + title + " returned successfully.");
        } else {
            System.out.println("Book not found in library database.");
        }
    }
}
