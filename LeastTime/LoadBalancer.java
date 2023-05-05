package LeastTime;

import java.util.List;

public class LoadBalancer {
    private List<Server> servers;
    private Algorithm algorithm;

    /**
     * 
     * @param servers
     */
    public LoadBalancer(List<Server> servers) {
        this.servers = servers;
        this.algorithm = new Algorithm();
    }

    /**
     * 
     * @return
     */
    public Server assignRequest() {
        Server server = algorithm.findBestServer(servers);
        server.setCurrentLoad(server.getCurrentLoad() + 1);
        return server;
    }

    /**
     * 
     */
    public void printServerStats() {
        for (Server server : servers) {
            System.out.println("Server: " + server.getIpAddress() + "Load: " + server.getCurrentLoad());
        }
    }
}
