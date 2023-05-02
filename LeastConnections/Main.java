package LeastConnections;

public class Main {
    public static void main(String[] args) {
        LoadBalancer lb = new LoadBalancer(3);
        for (int i = 0; i < 10; i++) {
            lb.distribute();
        }
    }
}
