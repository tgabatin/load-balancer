package RoundRobin;

public class Process {
    private int id;
    private int burstTime;

    public Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
    }

    public int getId() {
        return id;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }
}