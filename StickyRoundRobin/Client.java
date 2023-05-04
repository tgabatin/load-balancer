package StickyRoundRobin;

public class Client {
    private String ipAddress;

    public Client(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * 
     * @return ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }
}
