import java.io.IOException;
import java.util.Arrays;

public class SchedulerSim {
	/**
	 * Reads process file, writes to an array, passes to Scheduler that then runs.
	 * Prints relevant metric information.
	 * Amend to run different schedulers and determine necessary evaluation outcomes.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
	//	Process[] p = {new Process(1, 18, 0, 10), new Process(2, 5, 2, 2), new Process(3, 6, 3, 1)};

		ProcessReader pr = new ProcessReader();
		Process []  pa = pr.readProcesses("Processes.txt");
		Scheduler scheduler = new RR(pa,20);
		scheduler.runScheduler();
		System.out.println("Average wait time = " + scheduler.calculateAverageWaitTime());
		System.out.println("Average turnaround time = " + scheduler.calculateAverageTurnaroundTime());
		System.out.println("Total Run time = " + scheduler.getRuntime());
//		System.out.println("CPU Load= " + scheduler.getProcessorUsage(scheduler.getRuntime()));
	}
	
}
