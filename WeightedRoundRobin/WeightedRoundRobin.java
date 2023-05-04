package WeightedRoundRobin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class WeightedRoundRobin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of servers: ");
        int n = scanner.nextInt();
        List<Server> servers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight for server " + (i+1) + ": ");
            int weight = scanner.nextInt();
            servers.add(new Server(i, weight));
        }
        System.out.print("Enter number of requests: ");
        int m = scanner.nextInt();
        LoadBalancer loadBalancer = new LoadBalancer(servers);
        for (int i = 0; i < m; i++) {
            int serverId = loadBalancer.assignRequest();
            System.out.println("Request " + (i+1) + " assigned to server " + (serverId+1));
        }
    }
}

