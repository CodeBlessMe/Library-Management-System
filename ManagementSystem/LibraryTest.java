package ManagementSystem;

/**
 * The following code are tests for methods of LibraryManagementSystem.java.
 */


public class LibraryTest {

    public static void main(String[] args) {

        LibraryManagementSystem aLibrary = new LibraryManagementSystem();
        aLibrary.addSection("1");
        aLibrary.addSection("2");
        aLibrary.addSection("3");
        aLibrary.addSection("4");
        aLibrary.connectSections("1", "2");
        aLibrary.connectSections("1", "3");
        aLibrary.connectSections("2", "3");
        aLibrary.connectSections("3", "4");
        int cli1 = aLibrary.addClient("Mike","Mike@yahoo.com");
        int cli2 = aLibrary.addVIPClient("Fiona","Fiona@yahoo.com");
        int pub1 = aLibrary.addBlueRay("Farewell My concubine", 1993, "1");
        int pub2 = aLibrary.addBook("Guanzhong Luo", "Three Kingdoms", 1992, "2");
        int pub3 = aLibrary.addMagazine("Time", 1998, 5, "ten");
        int pub4 = aLibrary.addMagazine("Nature", 2011, 11, "2");
        int pub5 = aLibrary.addCD("Jay Chou", "Rice Field", 1998, "3");
        aLibrary.printAllClients();
        aLibrary.printAllPublications();
        aLibrary.findShortestPath(pub1, "4");
        aLibrary.borrowBook(cli1, "Guanzhong Luo", "Three Kingdoms");
        aLibrary.borrowBook(cli2, "Guanzhong Luo", "Three Kingdoms");
        aLibrary.lookAtMagazine(cli2, "Time", 1998, 5);
        aLibrary.borrowCD(cli2, "Jay Chou", "Rice Field");
        aLibrary.borrowCD(cli1, "Jay Chou", "Rice Field");
        aLibrary.returnItem(pub2);
    }

}
