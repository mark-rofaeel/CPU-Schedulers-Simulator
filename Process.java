
public class Process 
{
	String processName;
	int burstTime;
	int turnAroundTime;
	int waitingTime;
	int arrivalTime;
	
	public Process(String processName, int burstTime, int turnAroundTime, int waitingTime, int arrivalTime)
	{
		this.processName=processName;
		this.burstTime=burstTime;
		this.turnAroundTime=turnAroundTime;
		this.waitingTime=waitingTime;
		this.arrivalTime=arrivalTime;
	}
	public int getArrivalTime() 
	{
		return arrivalTime;
	}
	public int getBurstTime() 
	{
		return burstTime;
	}
	public String getProcessName() 
	{
		return processName;
	}
	public int getTurnAroundTime() 
	{
		return turnAroundTime;
	}
	public int getWaitingTime() 
	{
		return waitingTime;
	}
}
