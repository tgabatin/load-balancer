package StickyRoundRobin;

import java.util.ArrayList;

public class Server {
    private ArrayList<Client> clients;

    public Server() {
        clients = new ArrayList<Client>();
    }

    /**
     * 
     * @param client
     */
    public void handleRequest(Client client) {
        clients.add(client);
    }

    /**
     * 
     * @param client
     */
    public void removeClient(Client client) {
        clients.remove(client);
    }
}
