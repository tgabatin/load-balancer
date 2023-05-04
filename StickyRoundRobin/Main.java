package StickyRoundRobin;

public class Main {
    public static void main(String[] args) {
        LoadBalancer lb = new LoadBalancer();
        Server s1 = new Server();
        Server s2 = new Server();
        lb.addServer(s1);
        lb.addServer(s2);
        Client c1 = new Client("192.168.1.1");
        Client c2 = new Client("192.168.1.2");
        lb.handleRequest(c1);
        lb.handleRequest(c2);
    }
}
