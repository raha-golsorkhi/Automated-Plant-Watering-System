import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import java.io.IOException;

public class ButtonListener implements IODeviceEventListener {
    private final Pin Pump;
    private final Pin button;
    private final Pin LED;

    public ButtonListener(Pin pump, Pin button, Pin LED) {
        this.Pump = pump;
        this.button = button;
        this.LED = LED;
    }


    @Override
    public void onStart(IOEvent ioEvent) {

    }

    @Override
    public void onStop(IOEvent ioEvent) {

    }

    @Override
    public void onPinChange(IOEvent ioEvent) {
        if (ioEvent.getPin().getIndex() != button.getIndex()) {
            return;
        } else {
            try {
                LED.setValue(0);
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);

        }
    }

    @Override
    public void onMessageReceive(IOEvent ioEvent, String s) {
    }
}
