import javax.swing.*;
public class Window {
    /*
     * A class to easily use JOptionPanes to display messages
     */

    private JFrame j;
    public Window() {
        j = new JFrame();
    }

    //Displays a JOptionPane with a message
    public void msg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    //Displays a message and options for user to choose from
    public int option(String[] options, String msg) {
        return JOptionPane.showOptionDialog(
                j,
                msg, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options, // possible options
                options[0]); // default option
    }

    //Displays a message, options for user to choose from, and an Image to go along with it
    public int option1(String[] options, String msg, Icon i) {
        return JOptionPane.showOptionDialog(
                j,
                msg, // my message
                null, // dialog box title
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                i,
                options, // possible options
                options[0]); // default option
    }

    //Prints a message and skips a line
    public void println(String msg) {
        System.out.println(msg);
    }

    //Prints a message
    public void print(String msg) {
        System.out.println(msg);
    }

    //Displays a message with an icon
    public void msg2(String msg, Icon i){
        JOptionPane.showMessageDialog(
                j,
                msg,
                null,
                JOptionPane.DEFAULT_OPTION,
                i);
    }
}