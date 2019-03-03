package scheduler;

import processes.Process;

import java.util.ArrayList;

public class SJF {
    private int prevQueueLength = 0;

    private void sortQueue(ArrayList<Process> readyProcesses, ProcessComparator procComp) {
        readyProcesses.sort(procComp::compare);
    }

    public void tick(int currentTime, ArrayList<Process> readyProcesses, ProcessComparator procComp) {
        if (readyProcesses.size() > prevQueueLength || currentTime == 0) {
            sortQueue(readyProcesses, procComp);
        }

        prevQueueLength = readyProcesses.size();

        Process currentRunnig = readyProcesses.get(0);
        currentRunnig.setIsRunning(true);
        currentRunnig.incrementProgress();
    }
}
