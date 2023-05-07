package IPUrlHash;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {
    private List<Server> servers;

    public LoadBalancer() {
        servers = new ArrayList<Server>();
    }

    /**
     * 
     * @param server
     */
    public void addServer(Server server) {
        servers.add(server);
    }

    /**
     * 
     * @param server
     */
    public void removeServer(Server server) {
        servers.remove(server);
    }

    /**
     * 
     * @param ipAddress
     * @param url
     * @return
     */
    public Server selectServer(String ipAddress, String url) {
        int hashValue = (ipAddress + url).hashCode();
        int index = Math.abs(hashValue) % servers.size();
        return servers.get(index);
    }

    /**
     * 
     * @return
     */
    public List<Server> getServers() {
        return servers;
    }
}
