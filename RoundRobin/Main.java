package RoundRobin;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Process> queue = new ArrayList<>();
        System.out.println("Enter number of processes:");
        int n = scanner.nextInt();
        System.out.println("Enter quantum time:");
        int quantum = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter burst time for process " + i + ":");
            int burstTime = scanner.nextInt();
            queue.add(new Process(i, burstTime));
        }
        scanner.close();
    
        Scheduler scheduler = new Scheduler(queue, quantum);
        scheduler.run();
    }    
}


