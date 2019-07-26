# CPU-Scheduling-Algorithms
    
#To run:
---------------
* Open SchedulerSim.java
* Create an object of the scheduler type (FCFS, PS, SRTF, RR)
* call scheduler.runScheduler();

------------------------------------------------------------------
One of the main tasks of an operating system is scheduling processes to run on the CPU i.e.
to decide the order in which processes can access a processor.
This program schedules simulated CPU processes. 
The simulator program will implement four of the CPU scheduling algorithms (First Come
First Serve (FCFS), Shortest Remaining Time First (SRTF), which is the
preemptive version of Shortest Job First (SJF), Priority Scheduling (PS) (a higher
priority number indicates higher priority) and Round Robin (RR)), and evaluate
their effects on a set of processes.
The simulator selects a process to run from the ready queue based on the scheduling
algorithm chosen at runtime. Since the assignment intends to simulate a CPU scheduler, it
does not require any actual process creation or execution. When the CPU scheduler
chooses the next process, the simulator will simply print out which process was selected to
run at that time. The simulator output is similar to the Gantt chart.

#Design 
---------------------
* Processes
Each line in the input file Processes.txt represents a process, 4 integers separated
by spaces. The process information includes the Process ID, Burst Time, Arrival
Time, and Priority of a process. Process IDs are unique. Arrival time is the time at
which the scheduler receives the process and places it in the ready queue. Arrival
times may be duplicated, which means multiple processes may arrive at the same
time. Burst Time is the CPU time that a process needs to complete it task. Priority
indicates the importance of a Process. A higher value indicates higher priority.
Process.txt is a text file that containts a list of 200 processes in the following format (with the
header omitted).
The following table is an example of a three process input file.

Process ID Burst Time Arrival Time Priority
1001     83           0             3
1002     86           0             5
1003     49           0             5
... ... ... ...

* Class Process stores the Process ID, Burst Time, Arrival Time,
and Priority of a process. You can also add data members to keep
track of information in order to compute the statistics about the process such as its
waiting time, response time, and turnaround time.
It is assumed that the time to switch processes is 0. The methods of the Process class are
the get and set methods for each data member, the constructor for the class, and
method sneeded to compute the statistics for that process.
* Class called Scheduler simulates a CPU scheduler for an operating system.
The scheduler contains the ready queue and the ready queue is a circular linked list.
The only operations the scheduler performs is add and remove. The add operation
adds a process into the ready queue into its appropriate spot within the ready queue
according to the CPU scheduling algorithm implemented. The remove operation
removes a process from the ready queue according to the CPU scheduling algorithm
implemented.
* The driver class SchedulerSim contains only one method:
public static void main(String args[])
The main method receives, via the command line arguments, the name of the CPU
scheduler that the simulator program will execute. If Round Robin is the CPU
scheduler chosen then the time quantum value is also received via a command line
argument. The main method opens the file Processes.txt reading in the entire set of
processes and initiates execution of the simulator program. Its is assumed that 
there is only a single processor with only one core.
The command to launch your program using First Come First Serve scheduling:
java SchedulerSim FCFS
The command to launch your program using Shortest Remaining Time First
scheduling:
java SchedulerSim SRTF
The command to launch your program using Priority Scheduling:
java SchedulerSim PS
The command to launch your program using Round Robin scheduling with a time
quantum of 10:
java SchedulerSim RR 10
