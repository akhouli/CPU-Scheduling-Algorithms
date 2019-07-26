import java.util.Collections;

public class RR extends Scheduler {
	int quant;
	int quantpoint;
	int processpoint;
	public RR(Process [] pArray, int quant) {
		super(pArray);
		this.quant=quant;
	}
	public int currt;
	void runScheduler() {
	currt = 0;
	quantpoint = 0;
	processpoint = 0;
while(!readyQueue.isEmpty() || activeProcess != null || currt ==0) {
	checkForArrivingProcesses(currt);
	if(currt==0) {
	activeProcess=readyQueue.getFirst();
	processpoint=((processpoint+1)%readyQueue.size());
			System.out.println( " Process = " + activeProcess);
	}
	
	if(activeProcess.getBurstRemaining() == 0) {
				terminatedProcesses.add(activeProcess);
				readyQueue.remove(activeProcess);
					System.out.println( " Process = " + activeProcess);
				activeProcess.setTurnaroundTime(currt - activeProcess.getArrivalTime());
				if(!readyQueue.isEmpty()) {
					activeProcess.setPreemptedTime(currt);
					processpoint= (processpoint%readyQueue.size());
					activeProcess=readyQueue.get(processpoint);
					processpoint=((processpoint+1)%readyQueue.size());
					activeProcess.setWaitingTime(activeProcess.getWaitingTime() + (currt-activeProcess.getPreemptedTime()));

				}
			}
	if(readyQueue.isEmpty()) {
		activeProcess= null;
			}
	else {
		if(readyQueue.size()>1) {
			if(quantpoint == quant) {
				quantpoint=0;
					activeProcess.setPreemptedTime(currt);
					activeProcess = readyQueue.get(processpoint);
					processpoint=((processpoint+1)%readyQueue.size());
					activeProcess.setWaitingTime(activeProcess.getWaitingTime() + (currt-activeProcess.getPreemptedTime()));					
				}
		}
				}
	
				
				if(activeProcess!=null) {
					currt++;
					quantpoint++;
					activeProcess.reduceBurstRemainingTime();			
	}
}
	}
	void checkForArrivingProcesses(int t) {
		for(Process d : p ) {
			if(t == d.getArrivalTime())
				readyQueue.add(d);
		 }
//		System.out.println("ready" + readyQueue);
//		Collections.sort(readyQueue);
	}

	}