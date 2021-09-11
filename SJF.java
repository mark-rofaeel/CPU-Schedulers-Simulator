
public class SJF 
{
	public void shortestJobFirst(int totalProcesses, String [] process, int [] burstTime, int [] arrivalTime) 
	{ 
		int [] turnAroundTime = new int [totalProcesses]; 
		int [] waitingTime = new int [totalProcesses];
		int remainingTime[] = new int[totalProcesses]; 
		for (int i = 0; i < totalProcesses; i++) 
			remainingTime[i] = burstTime[i];		
		int complete = 0, calculateTime = 0, min = Integer.MAX_VALUE; 
		int current = 0, finishTime; 
		boolean check = false; 	
		while (complete != totalProcesses) 
		{  
			for (int j = 0; j < totalProcesses; j++)  
			{ 
				if ((arrivalTime[j] <= calculateTime) && (remainingTime[j] < min) && remainingTime[j] > 0) 
				{ 
					min = remainingTime[j]; 
					current = j; 
					check = true; 
				} 
			} 
			if (check == false) 
			{ 
				calculateTime++; 
			continue; 
			} 		
			remainingTime[current]--; 
			min = remainingTime[current]; 
			if (min == 0) 
				min = Integer.MAX_VALUE; 
			if (remainingTime[current] == 0) 
			{ 
				complete++; 
				check = false;  
				finishTime = calculateTime + 1;  
				waitingTime[current] = finishTime - burstTime[current] - arrivalTime[current]; 
				turnAroundTime[current] = burstTime[current] + waitingTime[current];
				if (waitingTime[current] < 0) 
					waitingTime[current] = 0; 
			} 
			calculateTime++; 
		} 
		System.out.println("Shortest Job First result:");
		System.out.println("Process" + '\t' + "  Waiting time" + '\t' + "Turn Around time");
		for(int i=0;i<totalProcesses;i++)
		{
			System.out.println(process[i] + '\t' + '\t' + waitingTime[i] + '\t' + '\t' + turnAroundTime[i]);
		}
		float avg_wt=0;
		float avg_tat=0;
		for(int j=0;j<totalProcesses;j++)
		{
			avg_wt+=waitingTime[j];
			avg_tat+=turnAroundTime[j];
		}
		System.out.println("Average waiting time "+(avg_wt/totalProcesses)+"\nAverage turn around time "+(avg_tat/totalProcesses));
	}
}