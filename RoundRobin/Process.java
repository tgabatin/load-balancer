package RoundRobin;

public class Process {
    private int id;
    private int burstTime;

    public Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
    }

    /**
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return
     */
    public int getBurstTime() {
        return burstTime;
    }

    /**
     * 
     * @param burstTime
     */
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }
}