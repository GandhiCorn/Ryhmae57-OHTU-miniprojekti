package ryhma57.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame implements ActionListener, KeyListener {

    static final String GENERATE = "generate";
    static final String CLEAR_LABEL = "clearLabel";
    static final String SEARCH = "search";

    private Application app;
    private JLabel infoLabel;
    private JTextField searchInput;
    private ListView listView;


    public Window(Application app) {
        this.app = app;
        this.setTitle("Application");
        /* set some default size so that window isn't 0x0 size */
        /*XXX we could load window geometry from config file */
        this.setSize(600, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.createComponents();
    }

    private void createComponents() {
        JButton button;
        JScrollPane scrollPane;
        JPanel pane, aligner;
        JPanel header;

        header = new JPanel(new BorderLayout());

        button = new JButton("Generate BibTeX file");
        button.addActionListener(this);
        button.setActionCommand(GENERATE);

        /*TODO we could add placeholder text for search field */
        this.searchInput = new JTextField();
        this.searchInput.addActionListener(this);
        this.searchInput.setActionCommand(SEARCH);
        this.searchInput.addKeyListener(this);

        header.add(this.searchInput, BorderLayout.CENTER);
        header.add(button, BorderLayout.LINE_END);
        this.add(header, BorderLayout.NORTH);

        /* add border and padding to the header panel */
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0,
                Color.BLACK);
        header.setBorder(BorderFactory.createCompoundBorder(bottomBorder,
                new EmptyBorder(4, 4, 4, 4)));

        pane = new FieldsForm(this.app);
        this.add(pane, BorderLayout.EAST);

        this.listView = new ListView(this.app);
        aligner = new JPanel();
        aligner.setLayout(new BorderLayout());
        aligner.add(this.listView, BorderLayout.PAGE_START);
        scrollPane = new JScrollPane(aligner);
        this.add(scrollPane, BorderLayout.CENTER);

        this.infoLabel = new JLabel("References were loaded succesfully.");
        this.infoLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        this.add(this.infoLabel, BorderLayout.SOUTH);
    }

    public ListView getListView() {
        return this.listView;
    }

    public void setErrorMessage(String error) {
        Timer timer;

        this.infoLabel.setText(error);
        timer = new Timer(10000, this);
        timer.start();
        timer.setActionCommand(CLEAR_LABEL);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(GENERATE)) {
            this.app.generateBibTex();
            JOptionPane.showMessageDialog(this,
                    "BibTex file was generated.");

        } else if (event.getActionCommand().equals(CLEAR_LABEL)) {
            this.infoLabel.setText("");
        } else if (event.getActionCommand().equals(SEARCH)) {
           this.app.search(this.searchInput.getText());
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
           this.searchInput.setText("");
           this.app.search("");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) {}
}
