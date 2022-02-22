package LibraryClass;

/**
 * CDs is the child class of Publications.
 * It stores CD.
 */

public class CDs extends Publications {

    private String author;

    public CDs(String author, String title, int year, String section) {
        super("CD", title, year, section);
        this.author = author;
        this.description = String.format("CD, %s, %s, %d", author, title, year);
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString(){
        return description;
    }
}
