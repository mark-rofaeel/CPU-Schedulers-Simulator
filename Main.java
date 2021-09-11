import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		RR rr = new RR();
		SJF sjf = new SJF();
		Priority priority = new Priority();
		MultilevelQueue multilevelqueue = new MultilevelQueue();
		System.out.println("Please enter the total number of processes:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String process[] = new String[n];
		int burstTime[] = new int[n];
		int arrivalTime[] = new int[n];
		int priority2[] = new int[n];
		int queueNumber[] = new int[n];
		int quantumTime;
		for(int i=0;i<n;i++)
		{
			System.out.println("Please enter the process's name:");
			process[i]= sc.next();
			System.out.println("Please enter the burst time:");
			burstTime[i]= sc.nextInt();
			System.out.println("Please enter the arrival time:");
			arrivalTime[i]= sc.nextInt();
			System.out.println("Please enter the process's priority:");
			priority2[i]= sc.nextInt();
			System.out.println("Please enter the queue number for multilevel queue:");
			queueNumber[i]= sc.nextInt();
		}
		System.out.println("Please enter the quantum time:");
		quantumTime= sc.nextInt();
		sjf.shortestJobFirst(n, process, burstTime, arrivalTime);
		System.out.println("----------------------------------------------------------");
		priority.priorityScheduling(n, process, burstTime, priority2);
		System.out.println("----------------------------------------------------------");
		rr.roundRobin(n, process, burstTime, quantumTime);
		System.out.println("----------------------------------------------------------");
		multilevelqueue.multilevelScheduling(n, process, burstTime, arrivalTime, queueNumber, quantumTime);
		System.out.println("----------------------------------------------------------");
	}
}