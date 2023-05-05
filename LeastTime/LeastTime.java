package LeastTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeastTime {
    public static void main(String[] args) {
        // Create a list of servers
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("192.168.1.1", 50));
        servers.add(new Server("192.168.1.2", 40));
        servers.add(new Server("192.168.1.3", 30));
        
        // Create a load balancer
        LoadBalancer loadBalancer = new LoadBalancer(servers);
        
        // Read requests from user input
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a request (or 'exit' to quit): ");
            String input = scanner.nextLine();
            
            if (input.equals("exit")) {
                break;
            }
            
            // Assign the request to a server and print server stats
            Server server = loadBalancer.assignRequest();
            System.out.println("Request assigned to server: " + server.getIpAddress());
            loadBalancer.printServerStats();
        }
        
        scanner.close();
    }
}
