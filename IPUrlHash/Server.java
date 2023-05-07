package IPUrlHash;

public class Server {
    private String ipAddress;
    private int port;
    private int requestCount;

    public Server(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.requestCount = 0;
    }

    /**
     * 
     * @return
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 
     * @param ipAddress
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * 
     * @return
     */
    public int getPort() {
        return port;
    }

    /**
     * 
     * @param port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * 
     * @return
     */
    public int getRequestCount() {
        return requestCount;
    }

    /**
     * 
     */
    public void processRequest() {
        requestCount++;
    }


}
