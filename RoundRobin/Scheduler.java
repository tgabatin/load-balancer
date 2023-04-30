package RoundRobin;
import java.util.*;

/**
 * This class represents a Round Robin scheduler, which schedules processes in
 * a circular order and assigns a fixed time slice, called a quantum, to each process.
 */
public class Scheduler {
    private List<Process> queue;
    private int quantum;
    private int time;

    /**
     * Constructs a new Scheduler object with the specified process queue and quantum.
     *
     * @param queue the list of processes to be scheduled
     * @param quantum the time slice assigned to each process
     */
    public Scheduler(List<Process> queue, int quantum) {
        this.queue = queue;
        this.quantum = quantum;
        this.time = 0;
    }

    /**
     * Runs the Round Robin scheduler on the process queue, using the specified quantum.
     * Calculates and prints the waiting time and turnaround time for each process, as well as
     * the average waiting time and average turnaround time.
     */
    public void run() {
        int n = queue.size();
        boolean[] completed = new boolean[n];
        int[] waitingTime = new int[n];
        int[] turnAroundTime = new int[n];
        int i = 0;

        while (true) {
            boolean done = true;
            for (int j = 0; j < n; j++) {
                if (!completed[j]) {
                    done = false;
                    Process process = queue.get(j);
                    if (process.getBurstTime() > quantum) {
                        time += quantum;
                        process.setBurstTime(process.getBurstTime() - quantum);
                    } else {
                        time += process.getBurstTime();
                        waitingTime[j] = time - process.getBurstTime();
                        turnAroundTime[j] = time;
                        completed[j] = true;
                    }
                }
            }
            if (done) {
                break;
            }
        }
        printResults(waitingTime, turnAroundTime);
    }

    /**
     * Prints the waiting time and turnaround time for each process in the queue,
     * as well as the average waiting time and average turnaround time.
     *
     * @param waitingTime an array of waiting times for each process
     * @param turnAroundTime an array of turnaround times for each process
     */
    private void printResults(int[] waitingTime, int[] turnAroundTime) {
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int n = queue.size();

        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");

        for (int i = 0; i < n; i++) {
            Process process = queue.get(i);
            System.out.println(process.getId() + "\t\t" + process.getBurstTime() + "\t\t" + waitingTime[i] + "\t\t" + turnAroundTime[i]);
            totalWaitingTime += waitingTime[i];
            totalTurnAroundTime += turnAroundTime[i];
        }
        System.out.println("Average Waiting Time: " + (float) totalWaitingTime / n);
        System.out.println("Average Turnaround Time: " + (float) totalTurnAroundTime / n);
    }
}
