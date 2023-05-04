package WeightedRoundRobin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeightedRoundRobin {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number of servers: ");
    int n = scanner.nextInt();
    List<Server> servers = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        System.out.print("Enter weight for server " + (i+1) + ": ");
        int weight = scanner.nextInt();
        servers.add(new Server(i, weight));
    }
    System.out.print("Enter number of requests: ");
    int m = scanner.nextInt();
    LoadBalancer lb = new LoadBalancer(servers);
    for (int j = 0; i < m; j++) {
        int serverId = lb.assignRequest();
        System.out.println("Request " + (j+1) + " assigned to server " + (serverId+1));
    }
}

