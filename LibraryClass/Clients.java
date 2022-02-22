package LibraryClass;

/**
 * Clients is the super class of VIPClient and NormalClient.
 * It procides common features and methods for VIPClient and NormalClient.
 */

public abstract class Clients {

    private String type;
    private String name;
    private String email;

    public Clients(String type, String name, String email) {
        this.type = type;
        this.name = name;
        this.email = email;
    }

    public String getDescription(){
        return type;
    };

    public String getName(){
        return name;
    };

    public String getEmail(){
        return email;
    };

    public boolean isVIP(){
        return type == "VIP";
    }

    public String toString() {
        return String.format("%s, %s, %s",type, name, email);
    }
}
