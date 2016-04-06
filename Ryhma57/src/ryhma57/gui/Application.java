package ryhma57.gui;

/**
 * This is the main class currently.
 */
public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        Window window;
        window = new Window(app);

        window.setVisible(true);
        System.out.println("test");
    }

    public void generateBibTex() {
        //XXX do something here
        System.out.println("Generate the bibtext file in the backend");
    }

    public void createNewBookReference() {
        //XXX do something here
        System.out.println("Create the book reference in the backend");
    }
}
