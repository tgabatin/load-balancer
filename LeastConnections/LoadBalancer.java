package LeastConnections;

import java.util.Arrays;

public class LoadBalancer {
    private Server[] servers;

    public LoadBalancer(int numServers) {
        servers = new Server[numServers];
        for (int i = 0; i < numServers; i++) {
            servers[i] = new Server();
        }
    }

    private Server findServerWithFewestConnections() {
        Server selectedServer = servers[0];
        for (int i = 1; i < servers.length; i++) {
            if (servers[i].getConnections() < selectedServer.getConnections()) {
                selectedServer = servers[i];
            }
        }
        return selectedServer;
    }

    public void distribute() {
        Server selectedServer = findServerWithFewestConnections();
        selectedServer.incrementConnections();
        System.out.println("Traffic directed to server with " + selectedServer.getConnections() + " connections");
    }
}
