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
        GraphicsPanel graphicsPanel = new GraphicsPanel();
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        /* horizontal slider
        JSlider headingSlider = new JSlider(-180, 180, 0);
        pane.add(headingSlider, BorderLayout.SOUTH);
        // vertical slider
        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST);
        */
        //IT WORKS
        //System.out.println(mesh.getTriangles().get(4).getVertices()[2].getZ());

        //headingSlider.addChangeListener(e -> graphicsPanel.repaint());
        //pitchSlider.addChangeListener(e -> graphicsPanel.repaint());

        //Vertex check = new Vertex(3,3,3);
        //check = MatrixHandler.verMult(check, MatrixHandler.findCameraSpaceMatrix(new Camera(1,1,1,90,0,0,0,0.1,1000)));
        //System.out.println(check.toString());


        pane.add(graphicsPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.add(graphicsPanel);
    }
}
