package put.io.patterns.implement;

public class SystemGarbageCollectorObserver implements SystemStateObserver{
    @Override
    public void update(SystemMonitor monitor) {
        update(monitor.getLastSystemState());
    }

    @Override
    public void update(SystemState state) {
        if (state.getAvailableMemory() < 200.00){
            System.out.println("> Running garbage collector...");
        }
    }
}



