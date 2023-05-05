package LeastTime;

public class Server {
    private String ipAddress;
    private int currentLoad;
    private int responseTime;

    public Server(String ipAddress, int responseTime) {
        this.ipAddress = ipAddress;
        this.currentLoad = 0;
        this.responseTime = responseTime;
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
     * @return
     */
    public int getCurrentLoad() {
        return currentLoad;
    }

    /**
     * 
     * @return
     */
    public int getResponseTime() {
        return responseTime;
    }

    /**
     * 
     * @param currentLoad
     */
    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }
}
