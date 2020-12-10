package put.io.patterns.implement;

public interface SystemStateObserver {
    public void update(SystemMonitor monitor);
    public void update(SystemState newState);

}
