package LibraryClass;

import DataStructure.Queue;
import DataStructure.Vector;

/**
 * Publications is a super class for Books, BlueRays, CDs, and Magazines.
 * It provides common features and methods for Books, BlueRays, CDs, and Magazines.
 * And it also provides methods for borrowing and returning.
 */

public class Publications {

    protected String description = "Unknown";
    private String type;
    private String title;
    private String section;
    private int year;
    private int client = -1;
    private Queue VIPWaiting = new Queue();
    private Queue normalWaiting= new Queue();

    public Publications(String type, String title, int year, String section) {
        this.type = type;
        this.title = title;
        this.year = year;
        this.section = section;
    }

    public String getDescription(){
        return type;
    }

    public String getTitle(){
        return title;
    }

    public int getYear(){
        return year;
    };

    public String getType() {
        return type;
    }

    public String toString() {
        return String.format("%s, %s, %d",type, title, year);
    }

    public void borrowBy(int client){
        this.client = client;
    }

    public void returnBy(){
        this.client = -1;
    }

    public boolean isBorrowed(){
        return client >= 0;
    }

    public void addVIPWaiting(int client){
        VIPWaiting.push(client);
    }

    public void addNormalWaiting(int client){
        normalWaiting.push(client);
    }

    public boolean VIPIsEmpty(){
        return VIPWaiting.isEmpty();
    }

    public boolean normalIsEmpty(){
        return normalWaiting.isEmpty();
    }

    public int VIPGet(){
        return (int) VIPWaiting.pop();
    }

    public int normalGet(){
        return (int) normalWaiting.pop();
    }

    public String getSection() {
        return section;
    }
}

