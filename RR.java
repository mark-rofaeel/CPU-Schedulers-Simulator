
public class RR 
{
	Process process;
	public void roundRobin(int totalProcesses, String [] process, int [] burstTime, int quantumTime)
	{
		int [] turnAroundTime = new int [totalProcesses]; 
		int [] waitingTime = new int [totalProcesses];
		int a[] = new int [totalProcesses];
		for(int i=0;i<totalProcesses;i++)
		{
			a[i]=burstTime[i];
			turnAroundTime[i]=burstTime[i];
		}
		for(int i=0;i<totalProcesses;i++)
		{
			if(burstTime[i]>quantumTime)
			{
				burstTime[i]-=quantumTime;
				for(int j=0;j<totalProcesses;j++)
				{
					if((j!=i)&&(burstTime[j]!=0))
						turnAroundTime[j]+=quantumTime; 
				}
			}
			else
			{
				for(int j=0;j<totalProcesses;j++)
				{
					if((j!=i)&&(burstTime[j]!=0))
						turnAroundTime[j]+=burstTime[i];
				}
				burstTime[i]=0;
			}
		}
		for(int i=0;i<totalProcesses;i++)
		{
			waitingTime[i]=turnAroundTime[i]-a[i];
		}
		System.out.println("Round Robin result:");
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