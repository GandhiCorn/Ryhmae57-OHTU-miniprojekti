package ryhma57.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener {
    static final String CREATE = "create";
    static final String GENERATE = "generate";
    private Application app;

    public Window(Application app) {
        this.app = app;
        this.setTitle("Application");
        /* set some default size so that window isn't 0x0 size */
        /*XXX we could load window geometry from config file */
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.createDialog();
    }

    public void createDialog() {
        JFormattedTextField input;
        JPanel mainPane = new JPanel(new BorderLayout());
        JPanel labelPane = new JPanel(new GridLayout(0,1));
        JPanel inputPane = new JPanel(new GridLayout(0,1));

        mainPane.setBorder(BorderFactory.createTitledBorder("Create book reference"));

        labelPane.add(new JLabel("Author:"));
        input = new JFormattedTextField();
        input.setColumns(10);
        inputPane.add(input);

        labelPane.add(new JLabel("Title:"));
        input = new JFormattedTextField();
        input.setColumns(10);
        inputPane.add(input);

        labelPane.add(new JLabel("Year:"));
        input = new JFormattedTextField();
        input.setColumns(10);
        inputPane.add(input);

        labelPane.add(new JLabel("Journal:"));
        input = new JFormattedTextField();
        input.setColumns(10);
        inputPane.add(input);

        labelPane.add(new JLabel("Volume:"));
        input = new JFormattedTextField();
        input.setColumns(10);
        inputPane.add(input);

        labelPane.add(new JLabel("Number:"));
        input = new JFormattedTextField();
        input.setColumns(10);
        inputPane.add(input);

        labelPane.add(new JLabel("Pages:"));
        input = new JFormattedTextField();
        input.setColumns(10);
        inputPane.add(input);

        mainPane.add(labelPane, BorderLayout.CENTER);
        mainPane.add(inputPane, BorderLayout.LINE_END);
        this.add(mainPane, BorderLayout.NORTH);

        JButton button;
        button = new JButton("Save");
        button.addActionListener(this);
        button.setActionCommand(CREATE);
        mainPane.add(button, BorderLayout.SOUTH);

        button = new JButton("Generate BibTeX file");
        button.addActionListener(this);
        button.setActionCommand(GENERATE);
        this.add(button, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand() == CREATE) {
            //TODO get the contents of the input fields.
            this.app.createNewBookReference();
        } else if(event.getActionCommand() == GENERATE) {
            this.app.generateBibTex();
        }
    }
}
