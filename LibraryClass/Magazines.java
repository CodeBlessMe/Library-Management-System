package LibraryClass;

/**
 * Magazines is the child class of Publications.
 * It stores magazine.
 */

public class Magazines extends Publications {

    private int issue;

    public Magazines(String title, int year, int issue, String section) {
        super("Magazine", title, year, section);
        this.issue = issue;
        this.description = String.format("Magazine, %s, %d, %d", title, year, issue);
    }

    public int getIssue() {
        return issue;
    }

    @Override
    public String toString(){
        return description;
    }
}
