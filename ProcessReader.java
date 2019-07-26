
import java.io.*;
import java.util.LinkedList;

public class ProcessReader {

	LinkedList<Process> processes = new LinkedList<Process>();

	public Process[] readProcesses(String fileName) throws IOException {
		File file = new File("C:\\Users\\Ahmad\\eclipse-workspace\\OSN\\src\\Processes.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		String line;
		System.out.println("==================================================================");
		System.out.println("Beginning read of file from:  " + file.getCanonicalPath());
		while ((line = br.readLine()) != null) {
			if (line.startsWith("P")) {
				System.out.println("Header detected, ignoring...");
			} else {
				String[] pBits = line.split("\t");
				int pid = Integer.parseInt(pBits[0]);
				int bT = Integer.parseInt(pBits[1]);
				int aT = Integer.parseInt(pBits[2]);
				int priority = Integer.parseInt(pBits[3]);
				
				Process p = new Process(pid, bT, aT, priority);
				processes.add(p);
			}
		}
		
		br.close();
		System.out.println("Read successfully completed. " + processes.size() + " processes successfully loaded in.");
		System.out.println("==================================================================");
		return processes.toArray(new Process[processes.size()]);

	}
	public static void main(String[] args) {
		
	}

}
