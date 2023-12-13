package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private final List<Simulation> simulationList;

    private ExecutorService executorService;

    public SimulationEngine(List<Simulation> simulationList) {
        this.simulationList = simulationList;
    }

    public void runSync() {
        for (Simulation simulation : simulationList) {
            simulation.run();
        }
    }

    public void runAsync() {
//        List<Thread> simulationThreads = new ArrayList<>();
        for (Simulation simulation : simulationList) {
            Thread simThread = new Thread(simulation);
            simThread.start();
        }
    }

    public void awaitSimulationEnd() throws InterruptedException {
        executorService.shutdown();
        if(!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }

    public void runAsyncInThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (Simulation simulation : simulationList) {
            executorService.submit(simulation);
        }
    }
}
