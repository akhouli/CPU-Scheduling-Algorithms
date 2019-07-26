
public class Process implements Comparable<Process> {
	
	private int processID, arrivalTime;
	private int burstTime;
	private int priority;
	private int waitingTime;
	private int turnaroundTime;
	private int burstRemaining;
	private int preemptedTime;
	private int preempts;

	public Process(int pID, int bT, int aT, int prio) {
		processID = pID;
		burstTime = bT;
		arrivalTime = aT;
		priority = prio;
		burstRemaining = bT;
		waitingTime = 0;
		preemptedTime = aT;
		preempts = 0;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getProcessID() {
		return processID;
	}
	
	public void setProcessID(int processID) {
		this.processID = processID;
	}
	
	public int getBurstTime() {
		return burstTime;
	}
	
	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	public int getTurnaroundTime() {
		return turnaroundTime;
	}

	public void setTurnaroundTime(int turnaroundTime) {
		this.turnaroundTime = turnaroundTime;
	}
	
	public int getPreemptedTime() {
		return preemptedTime;
	}

	public void setPreemptedTime(int preemptedTime) {
		this.preemptedTime = preemptedTime;
	}

	public int getBurstRemaining() {
		return burstRemaining;
	}

	public void reduceBurstRemainingTime() {
		burstRemaining--;		
	}

	public int getPreempts() {
		return preempts;
	}

	public void setPreempts(int preempts) {
		this.preempts = preempts;
	}

	public void incrementPreempts() {
		preempts++;
		
	}

	public String toString() {
		return "Proccess: " + processID + ", Burst Time:  " + burstTime + ", Arriv. T: " + arrivalTime +", Priority: " + priority +"\n";
	}

	@Override
	public int compareTo(Process arg0) {
		return (this.getBurstRemaining() - arg0.getBurstRemaining());
	}

	
}
