import java.io.IOException;
import java.util.Timer;
import org.firmata4j.I2CDevice;
import org.firmata4j.IODevice;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;


public class Minor_Project{
    static final int A1 = 15;
    static final int D2 = 2;
    static final int D6 = 6;
    static final int D4 = 4;
    public final Pin myPairs;


    public Minor_Project(Pin myPairs) {
        this.myPairs = myPairs;
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        IODevice myArduino = new FirmataDevice("/dev/cu.usbserial-0001");
        myArduino.start();
        System.out.println("Starting...");
        myArduino.ensureInitializationIsDone();
        System.out.println("Initialized.");

        var moistureSensor = myArduino.getPin(A1);
        moistureSensor.setMode(Pin.Mode.ANALOG);
        var pump = myArduino.getPin(D2);
        pump.setMode(Pin.Mode.OUTPUT);
        var button = myArduino.getPin(D6);
        button.setMode(Pin.Mode.INPUT);
        var LED = myArduino.getPin(D4);
        LED.setMode(Pin.Mode.OUTPUT);

        I2CDevice i2cObj = myArduino.getI2CDevice((byte) 0x3C);
        SSD1306 myOled = new SSD1306(i2cObj, SSD1306.Size.SSD1306_128_64);
        myOled.init();

        var task = new MoistureCheck(myOled, pump, moistureSensor, LED, button);
        new Timer().schedule(task, 0, 1000);
        myArduino.addEventListener(new ButtonListener(pump, button, LED));
        /*var graph = new Graph(moistureSensor);
        System.out.println(graph);*/
        //Pin moitureSensor = myArduino.getPin(A1); // replace 0 with the index of your moisture sensor pin
        graphTask graph = new graphTask(moistureSensor);


    }

}
