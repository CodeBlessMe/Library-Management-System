package LibraryClass;

/**
 * Books is the child class of Publications.
 * It stores book.
 */

public class Books extends Publications {

    private String author;

    public Books(String author, String title, int year, String section) {
        super("Book", title, year, section);
        this.author = author;
        this.description = String.format("Book, %s, %s, %d", author, title, year);
    }

    public String getAuthor(){
        return author;
    }

    @Override
    public String toString(){
        return description;
    }
}