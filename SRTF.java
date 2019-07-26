import java.util.Collections;

public class SRTF extends Scheduler {

	public SRTF(Process [] pArray) {
		super(pArray);
	}
	public int currt;
	@Override
	void runScheduler() {
	currt = 0;

while(!readyQueue.isEmpty() || activeProcess != null || currt ==0) {
	checkForArrivingProcesses(currt);
	if(currt==0) {
	activeProcess=readyQueue.getFirst();
	
			System.out.println( " Process = " + activeProcess);
	}
	
	if(activeProcess.getBurstRemaining() == 0) {
				terminatedProcesses.add(activeProcess);
				readyQueue.remove(activeProcess);	
					System.out.println( " Process = " + activeProcess);
				activeProcess.setTurnaroundTime(currt - activeProcess.getArrivalTime());
				if(!readyQueue.isEmpty()) {
					activeProcess=readyQueue.getFirst();
					activeProcess.setWaitingTime(activeProcess.getWaitingTime() + (currt-activeProcess.getPreemptedTime()));

				}
			}
	if(readyQueue.isEmpty()) {
		activeProcess= null;
			}
	else {
		if(readyQueue.size()>1) {
			if(activeProcess.getBurstRemaining()>readyQueue.get(1).getBurstRemaining()) {
//					Process currentProcess = activeProcess;
					activeProcess.setPreemptedTime(currt);
					activeProcess = readyQueue.get(1);
					Collections.sort(readyQueue);
					activeProcess.setWaitingTime(activeProcess.getWaitingTime() + (currt-activeProcess.getPreemptedTime()));
//					System.out.println(activeProcess.getWaitingTime());
					
				}
		}
				}
	
				
				if(activeProcess!=null) {
					currt++;
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
		Collections.sort(readyQueue);
	}

	}