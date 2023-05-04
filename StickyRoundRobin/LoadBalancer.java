package StickyRoundRobin;

import java.util.ArrayList;

public class LoadBalancer {
    private ArrayList<Server> servers;
    private int currentIndex;

    public LoadBalancer() {
        servers = new ArrayList<Server>();
        currentIndex = 0;
    }

    /**
     * 
     * @param server
     */
    public void addServer(Server server) {
        servers.add(server);
    }

    /**
     * 
     * @param server
     */
    public void removeServer(Server server) {
        servers.remove(server);
    }

    /**
     * 
     * @param client
     */
    public void handleRequest(Client client) {
        Server server = getNextServer();
        server.handleRequest(client);
    }

    /**
     * 
     * @return
     */
    private Server getNextServer() {
        Server server = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % servers.size();
        return server;
    }
}
