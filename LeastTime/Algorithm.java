package LeastTime;

import java.util.List;

public class Algorithm {
    public Server findBestServer(List<Server> servers) {
        Server bestServer = null;
        int bestResponseTime = Integer.MAX_VALUE;

        for (Server server : servers) {
            if (server.getCurrentLoad() == 0 && server.getResponseTime() < bestResponseTime) {
                bestServer = server;
                bestResponseTime = server.getResponseTime();
            }
        }
        if (bestServer == null) {
            for (Server server : servers) {
                if (server.getResponseTime() < bestResponseTime) {
                    bestServer = server;
                    bestResponseTime = server.getResponseTime();
                }
            }
        }
        return bestServer;
    }
}
