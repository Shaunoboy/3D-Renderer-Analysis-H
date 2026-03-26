import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Renderer {
    //dw abt this, checking if matrix multipication works

    public static void main(String[] args) throws FileNotFoundException {

        //actual code now

        //set up frame
        JFrame frame = new JFrame();
        frame.setTitle("Analysis Project");

        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        // horizontal slider
        JSlider xPosSlider = new JSlider(-2000, 2000, 0);
        pane.add(xPosSlider, BorderLayout.SOUTH);
        // vertical slider
        JSlider xRotSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(xRotSlider, BorderLayout.EAST);

        GraphicsPanel graphicsPanel = new GraphicsPanel(xPosSlider, xRotSlider);

        xPosSlider.addChangeListener(e -> graphicsPanel.repaint());
        xRotSlider.addChangeListener(e -> graphicsPanel.repaint());

        pane.add(graphicsPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.add(graphicsPanel);
    }
}
