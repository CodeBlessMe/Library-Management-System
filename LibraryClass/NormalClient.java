package LibraryClass;

/**
 * NormalClient is the child class of Clients.
 * It stores non-VIP client.
 */

public class NormalClient extends Clients {

    public NormalClient(String name, String email) {
        super("Normal", name, email);
    }
}