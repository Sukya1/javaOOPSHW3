import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
	private String location; 
	private ArrayList<Book> books;
	private static String openingHours;
	
	public Library(String location) {
		this.location = location;
		openingHours = "Mon - Fri 9am - 5pm";
		books = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	public void printAddress() {
		System.out.println(location);
	}
	public static void printOpeningHours() {
		System.out.println(openingHours);
	}
	public void borrowBook(String book) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(book) && !books.get(i).isBorrowed()) {
				books.get(i).borrowed();
			}
		}
	}
	
	public void printAvailableBooks() {
		for (int i = 0; i < books.size(); i++) {
			if (!books.get(i).isBorrowed()) {
				System.out.println(books.get(i).getTitle());
			}
		}
	}
	
	public void returnBook(String book) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(book) && books.get(i).isBorrowed()) {
				books.get(i).returned();
			}
		}
	}
	
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}