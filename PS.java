import java.util.Collections;
import java.util.Comparator;


import java.util.Collections;

	public class PS extends Scheduler {

		public PS(Process [] pArray) {
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
							Collections.sort(readyQueue,Priority);
							activeProcess=readyQueue.getFirst();
							activeProcess.setWaitingTime(activeProcess.getWaitingTime() + (currt-activeProcess.getPreemptedTime()));

						}
					}
			if(readyQueue.isEmpty()) {
				activeProcess= null;
					}
			else {
				if(readyQueue.size()>1) {
					if(activeProcess.getPriority()<readyQueue.get(1).getPriority()) {
							activeProcess.setPreemptedTime(currt);
							Collections.sort(readyQueue,Priority);
							activeProcess = readyQueue.get(1);
							activeProcess.setWaitingTime(activeProcess.getWaitingTime() + (currt-activeProcess.getPreemptedTime()));	
						}
				}
						}
						if(activeProcess!=null) {
							currt++;
							activeProcess.reduceBurstRemainingTime();			
			}
		}
			}
		public static Comparator<Process> Priority = new Comparator<Process>() {

			@Override
			public int compare(Process p1, Process p2) {
				return -(p1.getPriority() - p2.getPriority());
			}
		};

		void checkForArrivingProcesses(int t) {
			for(Process d : p ) {
				if(t == d.getArrivalTime())
					readyQueue.add(d);
			 }
			Collections.sort(readyQueue,Priority);
		}

		}