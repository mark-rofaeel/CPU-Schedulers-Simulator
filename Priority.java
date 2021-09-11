
public class Priority 
{     
	public void priorityScheduling(int totalProcesses, String [] process, int [] burstTime, int [] priority) 
	{
		String x;
		int y;
	    int [] turnAroundTime = new int [totalProcesses]; 
		int [] waitingTime = new int [totalProcesses];
	    for(int i=0;i<totalProcesses-1;i++)
	    {
	    	for(int j=i+1;j<totalProcesses;j++)
		    {
	    		if(priority[i]>priority[j])
	    		{
	    			y=priority[i];
				    priority[i]=priority[j];
				    priority[j]=y;
				     
				    y=burstTime[i];
				    burstTime[i]=burstTime[j];
				    burstTime[j]=y;
				    
				    x=process[i];
				    process[i]=process[j];
				    process[j]=x;
			    }
		    }
	    }
	    float avg_wt=0;
		float avg_tat=0;
		waitingTime[0]=0;
		turnAroundTime[0]=burstTime[0];
		for(int j=1;j<totalProcesses;j++)
		{
			waitingTime[j]=turnAroundTime[j-1];
			turnAroundTime[j]=waitingTime[j]+burstTime[j];
			avg_wt+=waitingTime[j];
			avg_tat+=turnAroundTime[j];
		}
		System.out.println("Priority scheduling result:");
		System.out.println("Process" + '\t' + "  Waiting time" + '\t' + "Turn Around time" + '\t' + "Priority");
		for(int i=0;i<totalProcesses;i++)
		{
			System.out.println(process[i] + '\t' + '\t' + waitingTime[i] + '\t' + '\t' + turnAroundTime[i] + '\t' + '\t' + priority[i]);
		}
		System.out.println("Average waiting time "+(avg_wt/totalProcesses)+"\nAverage turn around time "+(avg_tat/totalProcesses));
	}
}