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

    public String getIpAddress() {
        return ipAddress;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }
}
