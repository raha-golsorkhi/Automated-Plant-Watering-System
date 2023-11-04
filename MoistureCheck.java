import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;
import java.io.IOException;
import java.util.TimerTask;

public class MoistureCheck extends TimerTask{
    private SSD1306 myOled;
    private final Pin Pump;
    private final Pin sensor;
    private final Pin LED;
    private final Pin Button;
    public MoistureCheck(SSD1306 oled, Pin pump, Pin sensor, Pin LED, Pin button) {
        this.myOled = oled;
        this.Pump = pump;
        this.sensor = sensor;
        this.LED = LED;
        Button = button;
    }

    public void Sensor(SSD1306 aDisplayObject){
        myOled = aDisplayObject;

}
    @Override
    public void run() {
        if (LED.getValue()==0 && Button.getValue()==1)
        {
            try {
                Pump.setValue(0);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            cancel();
            return;
        }
        try {
            LED.setValue(1);
            Pump.setValue(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        myOled.getCanvas().setTextsize(1);
        myOled.getCanvas().drawString(0,10, String.valueOf(sensor.getValue()));
        myOled.display();

        if(sensor.getValue()>675){
            try {
                Pump.setValue(1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            myOled.getCanvas().drawString(0,20,"soil is dry          ");
            myOled.getCanvas().drawString(0,30,"pump is on          ");
            myOled.display();
        } else if (sensor.getValue()<675&& sensor.getValue()>580) {
            try {
                Pump.setValue(1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            myOled.getCanvas().drawString(0, 20, "soil is damp       ");
            myOled.getCanvas().drawString(0,30,"pump is on          ");
            myOled.display();
        }
        else if (sensor.getValue() <= 580) {
            try {
                Pump.setValue(0);
                Thread.sleep(5000);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
            myOled.getCanvas().drawString(0, 20, "soil is wet       ");
            myOled.getCanvas().drawString(0,30,"pump is off          ");
            myOled.display();
        }
    }
