import java.util.LinkedList;

public class FCFS extends Scheduler{

	public FCFS(Process [] pArray) {
		super(pArray);
	}

int currt;
	@Override
	void runScheduler() {
		currt = 0;

while(!readyQueue.isEmpty() || activeProcess != null || currt ==0) {
	checkForArrivingProcesses(currt);
	if(currt==0) {
	activeProcess=readyQueue.getFirst();
			System.out.println("Time = " + currt + " Process = " + activeProcess);
	}
			if(activeProcess.getBurstRemaining() == 0) {
				terminatedProcesses.add(activeProcess);
				readyQueue.removeFirst();	
				activeProcess.setTurnaroundTime(currt - activeProcess.getArrivalTime());
				if(readyQueue.isEmpty()) {
					activeProcess= null;
				}
				else {
					activeProcess = readyQueue.getFirst();
					activeProcess.setWaitingTime(currt - activeProcess.getArrivalTime());
					System.out.println(activeProcess.getWaitingTime());
					System.out.println("Time = " + currt + " Process = " + activeProcess);
				}
			}			
				currt++;
				if(activeProcess!=null) {
				activeProcess.reduceBurstRemainingTime();
	}
	}
	}

	
	void checkForArrivingProcesses(int t) {
		for(Process d : p )
			if(t == d.getArrivalTime())
				readyQueue.add(d);
		 }
	

	}
	
	
	


