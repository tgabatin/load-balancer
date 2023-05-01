package LeastConnections;

public class Server {
    private int connections;

    public Server() {
        this.connections = 0;
    }

    public int getConnections() {
        return connections;
    }

    public void incrementConnections() {
        ++connections;
    }

    public void decrementConnections() {
        --connections;
    }

}
