package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver {

    private int licznik = 0;

    @Override
    public void update(SystemMonitor monitor) {
        update(monitor.getLastSystemState());
    }

    @Override
    public void update(SystemState state) {
        int roznica = state.getUsbDevices() - licznik;

        if (roznica != 0) {
            licznik = state.getUsbDevices();

            System.out.println(String.format("Zmieniła się liczba urządzeń USB"));
        }
    }
}



