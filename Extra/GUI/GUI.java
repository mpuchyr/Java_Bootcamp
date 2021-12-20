import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());
        JButton button = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        frame.add(button, BorderLayout.WEST);
        frame.add(button2, BorderLayout.EAST);
        frame.setVisible(true);
    }
}