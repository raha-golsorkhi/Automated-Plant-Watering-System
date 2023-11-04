import edu.princeton.cs.introcs.StdDraw;
import org.firmata4j.Pin;
import java.awt.*;
import java.util.HashMap;

public class graphTask {
    public Pin sensor;

    graphTask(Pin sensor) throws InterruptedException {
        this.sensor = sensor;
        //setting up hashmap for drawing the graph
        HashMap<Integer, Integer> myPairs = new HashMap<>();
        //System.out.println(myPairs); to ensure what is inside my hashmap
        StdDraw.setXscale(0,2*sensor.getIndex());
        StdDraw.setYscale(-1023,0);

        StdDraw.text(sensor.getIndex()/1.5,-1023,"Time[s]");
        StdDraw.text(-0.5,-512,"Voltage [V]", 90);
        StdDraw.text(sensor.getIndex()/1.5,-30,"soil condition");

        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.BLUE);

        StdDraw.line(0,-1023,0,0);
        StdDraw.line(-70,-1000,100,-1000);

        //infinite while loop, to collect data and draw graph infinitely
        while(true){
            for(int i=1; i<sensor.getIndex(); i++){
                int sensorValue = -(int) sensor.getValue();
                myPairs.put(i, sensorValue);
                myPairs.forEach((xValue,yValue)->StdDraw.text(xValue,yValue,"*"));
                Thread.sleep(1000);
        }
    }
    }}
