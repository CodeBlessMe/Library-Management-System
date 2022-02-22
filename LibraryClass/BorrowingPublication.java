package LibraryClass;

/**
 * BorrowingPublication is a class for borrowing publications.
 */

import DataStructure.Vector;

public class BorrowingPublication {

    private String type;
    private Vector publications;
    private Vector clients;
    private int id;

    //Constructor, get type of publication, vector of publications and vector of clients.
    public BorrowingPublication(String type, Vector publications, Vector clients) {
        this.type = type;
        this.publications = publications;
        this.clients = clients;
        id = -1;
    }

    //The method for borrowing books.
    public int borrowBook(int client, String author, String title) {

        Books book = null;
        Publications publi = null;

        for (int i = 0; i < publications.getSize(); i++) {
            publi = (Publications) publications.get(i);
            if (publi.getType() != "Book")
                continue;
            book = (Books) publications.get(i);
            if (book.getTitle() == title && book.getAuthor() == author){
                id = i;
                break;
            }
        }
        checkBorrow(id, client, publi);
        return id;
    }

    //The method for borrowing magazines.
    public int borrowMagazine(int client, String title, int yearOfPublication, int issue) {

        Magazines magazine = null;
        Publications publi = null;

        for (int i = 0; i < publications.getSize(); i++) {
            publi = (Publications) publications.get(i);
            if (publi.getType() != "Magazine")
                continue;
            magazine = (Magazines) publications.get(i);
            if (magazine.getTitle() == title && magazine.getYear() == yearOfPublication
                    && magazine.getIssue() == issue){
                id = i;
                break;
            }
        }
        checkBorrow(id, client, publi);
        return id;
    }

    //The method for borrowing blueRays.
    public int borrowBlueRay(int client, String title, int yearOfPublication) {

        BlueRays blueRays = null;
        Publications publi = null;

        for (int i = 0; i < publications.getSize(); i++) {
            publi = (Publications) publications.get(i);
            if (publi.getType() != "Magazine")
                continue;
            blueRays = (BlueRays) publications.get(i);
            if (blueRays.getTitle() == title && blueRays.getYear() == yearOfPublication){
                id = i;
                break;
            }
        }
        checkBorrow(id, client, publi);
        return id;
    }

    //The method for borrowing CDs.
    public int borrowCD(int client, String author, String title) {

        CDs CD = null;
        Publications publi = null;

        for (int i = 0; i < publications.getSize(); i++) {
            publi = (Publications) publications.get(i);
            if (publi.getType() != "CD")
                continue;
            CD = (CDs) publications.get(i);
            if (CD.getTitle() == title && CD.getAuthor() == author){
                id = i;
                break;
            }
        }
        checkBorrow(id, client, publi);
        return id;
    }

    //Depending on whether the target is borrowed or not, different actions are taken.
    private void checkBorrow(int id, int client, Publications publi) {

        //When the target does not exist.
        if (id == -1)
            System.out.println("There is no this publication in the library.");

        //When the target is borrowed.
        if (publi.isBorrowed()){
            Clients clientBorrow = (Clients) clients.get(client);
            if (clientBorrow.isVIP()) {
                publi.addVIPWaiting(client);
                System.out.println("Add to the vip list!");
            }
            else{
                publi.addNormalWaiting(client);
                System.out.println("Add to the normal list!");
            }
        }
        //When the target is available.
        else {
            publi.borrowBy(client);
            System.out.println("Borrowing success!");
        }
    }

}
