import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());
        JButton button = new JButton("West");
        JButton button2 = new JButton("East");
        JButton button3 = new JButton("Center");
        JButton button4 = new JButton("North");
        JButton button5 = new JButton("South");
        frame.add(button, BorderLayout.WEST);
        frame.add(button2, BorderLayout.EAST);
        frame.add(button3, BorderLayout.CENTER);
        frame.add(button4, BorderLayout.NORTH);
        frame.add(button5, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}