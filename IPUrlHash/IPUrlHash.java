package IPUrlHash;

import java.util.Scanner;

public class IPUrlHash {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter server information (IP address, port number), one per line. Enter a blank line to finish.");
        String input = scanner.nextLine().trim();
        while (!input.isEmpty()) {
            String[] parts = input.split(" ");
            String ipAddress = parts[0];
            int port = Integer.parseInt(parts[1]);
            Server server = new Server(ipAddress, port);
            loadBalancer.addServer(server);
            input = scanner.nextLine().trim();
        }
        
        System.out.println("Load balancer successfully initialized with the following servers:");
        for (Server server : loadBalancer.getServers()) {
            System.out.println(server.getIpAddress() + ":" + server.getPort());
        }
        
        while (true) {
            System.out.println("Enter client IP address (or 'exit' to quit):");
            String ipAddress = scanner.nextLine().trim();
            if (ipAddress.equals("exit")) {
                break;
            }
            
            System.out.println("Enter requested URL:");
            String url = scanner.nextLine().trim();
            
            Server selectedServer = loadBalancer.selectServer(ipAddress, url);
            selectedServer.processRequest();
            System.out.println("Request processed by " + selectedServer.getIpAddress() + ":" + selectedServer.getPort() + " (total requests: " + selectedServer.getRequestCount() + ")");
        }
        scanner.close();
    }
}