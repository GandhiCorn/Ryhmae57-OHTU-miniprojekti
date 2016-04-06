package ryhma57.gui;
import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        this.setTitle("Application");
        /* set some default size so that window isn't 0x0 size */
        /*XXX we could load window geometry from config file */
        this.setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
