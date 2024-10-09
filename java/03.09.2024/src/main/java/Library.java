import java.util.Scanner;
import java.util.ArrayList;

import java.util.List;
public class Library {
	List<Book> booksList=new ArrayList<>();
	public void addBook(Book book)
	{
		booksList.add(book);
		System.out.println("Book added: " + book.getName());
	}
	
	public String searchBook(String bookName)
	{
		for(Book book : booksList)
		{
			if(book.getName().equalsIgnoreCase(bookName) && book.getQuantity()==0)
			{
				System.out.println("Currently Unavailable");
				return book.bookDetails();
			}
			else if(book.getName().equalsIgnoreCase(bookName))
			{ 
				return book.bookDetails();
			}
		}
		return "No book found";
	}
	
	public boolean checkOutBook(String bookName)
	{
		for (Book book : booksList) {
            if (book.getName().equalsIgnoreCase(bookName) && book.getQuantity() > 0) {
                book.setQuantity(book.getQuantity() - 1);
                System.out.println("Checked out: " + bookName);
                return true;
            }
        }
        System.out.println("Book not available or not found.");
        return false;
	}
	
	
	public boolean returnBook(String bookName) 
	{
        for (Book book : booksList) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                book.setQuantity(book.getQuantity() + 1);
                System.out.println("Returned: " + bookName);
                return true;
            }
        }
        System.out.println("Book not found.");
        return false;
    }
	
	
	 public double getPrice(String bookName) 
	 {
	        for (Book book : booksList) {
	            if (book.getName().equalsIgnoreCase(bookName)) {
	                return book.getPrice();
	            }
	        }
	        System.out.println("Book not found.");
	        return -1; // Indicates book not found
	  }
	 
	 
	 public void listAllBooks() 
	 {
	        if (booksList.isEmpty()) {
	            System.out.println("No books available.");
	        } else {
	            for (Book book : booksList) {
	                System.out.println(book.getName());
	            }
	        }
	 }
}
