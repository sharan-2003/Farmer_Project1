package Farmer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapter2 extends WindowAdapter {
    public void windowClosing(WindowEvent w) {
        System.exit(0);
    }
}
