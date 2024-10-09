import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
        int choice;
		Library obj=new Library();
		obj.addBook(new Book("Book1","Vara",1922,5));
		obj.addBook(new Book("Book2","Siri",2203,2));
		do {
            System.out.println("\nMain Menu");
            System.out.println("---------");
            System.out.println("1. Add Book");
            System.out.println("2. Checkout Book");
            System.out.println("3. Return Book");
            System.out.println("4. Get Price");
            System.out.println("5. List all Books");
            System.out.println("6.Search for a book");
            System.out.println("7. Exit");
            System.out.print("Enter the choice (1..7): ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity in stock: ");
                    int qtyInStock = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    obj.addBook(new Book(name, author, price, qtyInStock));
                    break;

                case 2:
                    System.out.print("Enter book name to checkout: ");
                    String checkoutName = scanner.nextLine();
                    obj.checkOutBook(checkoutName);
                    break;

                case 3:
                    System.out.print("Enter book name to return: ");
                    String returnName = scanner.nextLine();
                    obj.returnBook(returnName);
                    break;

                case 4:
                    System.out.print("Enter book name to get price: ");
                    String priceName = scanner.nextLine();
                    double bookPrice = obj.getPrice(priceName);
                    if (bookPrice != -1) {
                        System.out.println("Price of " + priceName + ": $" + bookPrice);
                    }
                    break;

                case 5:
                    obj.listAllBooks();
                    break;
                    
                case 6:
                	System.out.println("Enter the book name to search:");
                	String bookName=scanner.nextLine();
                	System.out.println(obj.searchBook(bookName));
                	break;

                case 7:
                    System.out.println("Exiting...");
                    break; 

                default:
                    System.out.println("Invalid choice, please enter a number between 1 and 7.");
                    break;
            }
        } while (choice != 7);
		
		scanner.close();
	}
}

