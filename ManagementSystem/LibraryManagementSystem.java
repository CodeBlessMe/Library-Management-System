/**
 * These methods are implementations of methods of ILibraryManagement.java.
 * Please refer to ILibraryManagement.jav for notes of these methods.
 *
 * Author: Minxing Jiang
 * Time: 2022.01.08
 * The final project of Algorithms and Data structures
 */

package ManagementSystem;

import DataStructure.Graph;
import DataStructure.ShortestPath;
import DataStructure.Vector;
import LibraryClass.*;

public class LibraryManagementSystem implements ILibraryManagement{

    private Graph graph = new Graph();
    private Vector clients = new Vector();
    private Vector publications = new Vector();

    @Override
    public int addBook(String author, String title, int yearOfPublication, String section) {
        Publications book = new Books(author, title, yearOfPublication, section);
        publications.addLast(book);
        return publications.getSize()-1;
    }

    @Override
    public int addMagazine(String title, int yearOfPublication, int issue, String section) {
        Publications magazine = new Magazines(title, yearOfPublication, issue, section);
        publications.addLast(magazine);
        return publications.getSize()-1;
    }

    @Override
    public int addBlueRay(String title, int yearOfPublication, String section) {
        Publications blueRay = new BlueRays(title, yearOfPublication, section);
        publications.addLast(blueRay);
        return publications.getSize()-1;
    }

    @Override
    public int addCD(String author, String title, int yearOfPublication, String section) {
        Publications CD = new CDs(author, title, yearOfPublication, section);
        publications.addLast(CD);
        return publications.getSize()-1;
    }

    @Override
    public int addClient(String name, String email) {
        Clients client = new NormalClient(name, email);
        clients.addLast(client);
        return clients.getSize()-1;
    }

    @Override
    public int addVIPClient(String name, String email) {
        Clients client = new VIPClient(name, email);
        clients.addLast(client);
        return clients.getSize()-1;
    }

    @Override
    public void printAllPublications() {
        StringBuilder result = new StringBuilder();
        int pubSize = publications.getSize();
        result.append(String.format("There are %d publications:\n", pubSize));
        for (int i = 0; i < pubSize; i++)
            result.append(publications.get(i) + "\n");
        System.out.println(result);
    }

    @Override
    public void printAllClients() {
        StringBuilder result = new StringBuilder();
        int clientsSize = clients.getSize();
        result.append(String.format("There are %d clietns:\n", clientsSize));
        for (int i = 0; i < clientsSize; i++)
            result.append(clients.get(i) + "\n");
        System.out.println(result);
    }

    @Override
    public int borrowBook(int client, String author, String title) {
        BorrowingPublication aBorrow = new BorrowingPublication("Book", publications, clients);
        return aBorrow.borrowBook(client, author, title);
    }

    @Override
    public int lookAtMagazine(int client, String title, int yearOfPublication, int issue) {
        BorrowingPublication aBorrow = new BorrowingPublication("Magazine", publications, clients);
        return aBorrow.borrowMagazine(client, title, yearOfPublication, issue);
    }

    @Override
    public int borrowBlueRay(int client, String title, int yearOfPublication) {
        BorrowingPublication aBorrow = new BorrowingPublication("BlueRay", publications, clients);
        return aBorrow.borrowBlueRay(client, title, yearOfPublication);
    }

    @Override
    public int borrowCD(int client, String author, String title) {
        BorrowingPublication aBorrow = new BorrowingPublication("CD", publications, clients);
        return aBorrow.borrowCD(client, author, title);
    }

    @Override
    public int returnItem(int publicationID) {
        Publications publi = (Publications) publications.get(publicationID);
        publi.returnBy();
        int client = -1;
        if (!publi.VIPIsEmpty())
            client = publi.VIPGet();
        else if (!publi.normalIsEmpty())
            client = publi.normalGet();
        else
            return client;
        Clients waitClient = (Clients) clients.get(client);
        System.out.println("Return successful! Send email to: " + waitClient.getEmail());
        return client;
    }

    @Override
    public void addSection(String name) {
        graph.addNode(name);
    }

    @Override
    public void connectSections(String section1, String section2) {
        graph.addEdge(section1, section2);
    }

    @Override
    public void findShortestPath(int publicationID, String startSection) {
        Publications publi = (Publications) publications.get(publicationID);
        String endSection = publi.getSection();
        System.out.println("Shortest Path Towards Publication: ");
        ShortestPath shortestPath = new ShortestPath(graph, startSection, endSection);
    }
}
