package WeightedRoundRobin;

import java.util.List;

public class LoadBalancer {
    private List<Server> servers;
    private int gcd;
    private int maxWeight;
    private int[] nextServer;
    private int[] currentWeight;
    private int currentIndex;

    /**
     * 
     * @param servers
     */
    public LoadBalancer(List<Server> servers) {
        this.servers = servers;
        this.gcd = computeGCD();
        this.maxWeight = getMaxWeight();
        this.nextServer = new int[servers.size()];
        this.currentWeight = new int[servers.size()];
        this.currentIndex = findInitialServer();
    }

    /**
     * 
     * @return
     */
    public int assignRequest() {
        int serverIndex = currentIndex;
        int maxWeightServerIndex = currentIndex;
        int currentMaxWeight = -1;
        for (int i = 0; i < servers.size(); i++) {
            int weight = servers.get(serverIndex).getWeight();
            currentWeight[serverIndex] += weight;
            if (currentWeight[serverIndex] > currentMaxWeight) {
                currentMaxWeight = currentWeight[serverIndex];
                maxWeightServerIndex = serverIndex;
            }
            serverIndex = (serverIndex + 1) % servers.size();
        }
        currentWeight[maxWeightServerIndex] -= maxWeight;
        currentIndex = (maxWeightServerIndex + 1) % servers.size();
        return servers.get(maxWeightServerIndex).getId();
    }

    /**
     * 
     * @return
     */
    private int computeGCD() {
        int[] weights = new int[servers.size()];
        for (int i = 0; i < servers.size(); i++) {
            weights[i] = servers.get(i).getWeight();
        }
        int gcd = weights[0];
        for (int i = 1; i < servers.size(); i++) {
            gcd = gcd(gcd, weights[i]);
        }
        return gcd;
    }

    /**
     * 
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * 
     * @return
     */
    private int getMaxWeight() {
        int maxWeight = servers.get(0).getWeight();
        for (int i = 1; i < servers.size(); i++) {
            if (servers.get(i).getWeight() > maxWeight) {
                maxWeight = servers.get(i).getWeight();
            }
        }
        return maxWeight;
    }

    private int findInitialServer() {
        int index = -1;
        int maxNextServer = -1;
        for (int i = 0; i < servers.size(); i++) {
            nextServer[i] = servers.get(i).getWeight() / gcd;
            if (nextServer[i] > maxNextServer) {
                maxNextServer = nextServer[i];
                index = i;
            }
        }
        return index;
    }

    
}
