import java.util.ArrayList;

public class MultilevelQueue 
{
	public void multilevelScheduling(int totalProcesses, String [] process, int [] burstTime, int [] arrivalTime, int [] queueNumber, int quantumTime) 
	{
		int [] finishTime=new int[totalProcesses];
		int [] turnAroundTime = new int [totalProcesses]; 
		int [] waitingTime = new int [totalProcesses];
		int [] remainingTime = new int[totalProcesses]; 
		int current = 0; 
		int counter = 0;
		for (int i = 0; i < totalProcesses; i++) 
			remainingTime[i] = burstTime[i];		
		ArrayList<Integer> highPriority = new ArrayList<Integer>();
		ArrayList<Integer> lowPriority = new ArrayList<Integer>();
		for (int i = 0;i <totalProcesses; i++) 
		{
			if (queueNumber[i]==1)
			{
				highPriority.add(i);                            
			}
		}

		int[] highPriotityArray = new int[totalProcesses];  
		for (int i = 0;i <highPriority.size(); i++) 
		{
			highPriotityArray[i]=highPriority.get(i);   
		}
		int t = 0;
		while (true)
		{ //RR
			boolean done = true;
			for (int i = 0 ; i < highPriority.size(); i++)
			{
				if (remainingTime[highPriotityArray[i]] > 0)
				{
					done = false;                                    
					if (remainingTime[highPriotityArray[i]] > quantumTime && arrivalTime[highPriotityArray[i]]<=t)
					{
						t += quantumTime;
						remainingTime[highPriotityArray[i]] -= quantumTime;
					}
					else if(remainingTime[highPriotityArray[i]] <= quantumTime && arrivalTime[highPriotityArray[i]]<=t)
					{
						t = t + remainingTime[highPriotityArray[i]];
						finishTime[highPriotityArray[i]]=t;
						current=highPriotityArray[i];
						remainingTime[highPriotityArray[i]] = 0;
					}
					else if(remainingTime[highPriotityArray[i]]>quantumTime && arrivalTime[highPriotityArray[i]]>t && remainingTime[highPriotityArray[i-1]]==0)
					{
						t++;
						counter++;
					}
				}
			}
			if (done == true)
				break;
		}
		float avg_wt_total=0;
		float avg_tat_total=0;
		for (int i = 0;i <totalProcesses; i++) 
		{//FCFS
			if (queueNumber[i]==2)
			{
				lowPriority.add(i);
				int x = burstTime[i];
				burstTime[i]-=counter;
				finishTime[i]=finishTime[current]+burstTime[i];
				current=i;
				turnAroundTime[i]=finishTime[i]-arrivalTime[i];
				waitingTime[i]=turnAroundTime[i]-x;
				avg_wt_total+=waitingTime[i];
				avg_tat_total+=turnAroundTime[i];
			}
		}
		float avg_wt=0;
		float avg_tat=0;
		waitingTime[0]=0;
		turnAroundTime[0]=burstTime[0];
		for (int j = 0; j < highPriority.size(); j++) 
		{
			turnAroundTime[highPriotityArray[j]]=finishTime[highPriotityArray[j]]-arrivalTime[highPriotityArray[j]];
			waitingTime[highPriotityArray[j]]=turnAroundTime[highPriotityArray[j]]-burstTime[highPriotityArray[j]];
			avg_wt+=waitingTime[highPriotityArray[j]];
			avg_tat+=turnAroundTime[highPriotityArray[j]];

		}
			avg_wt_total+=avg_wt;
			avg_tat_total+=avg_tat;
			System.out.println("MultiLevel Queue result:");
			System.out.println("Process" + '\t' + "  Waiting time" + '\t' + "Turn Around time" + '\t' + "Queue time");
			for(int i=0;i<totalProcesses;i++)
			{
				System.out.println(process[i] + '\t' + '\t' + waitingTime[i] + '\t' + '\t' + turnAroundTime[i] + '\t' + '\t' + queueNumber[i]);
			}
			System.out.println("Average waiting time "+(avg_wt_total/totalProcesses)+"\nAverage turn around time "+(avg_tat_total/totalProcesses));
	}
}