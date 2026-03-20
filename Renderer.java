import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Renderer {
    //dw abt this, checking if matrix multipication works

    public static void main(String[] args) throws FileNotFoundException {

        //actual code now

        //set up frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);

        //set up camera
        Camera camera = new Camera(1,1,1,90,0,0,0,0.1,1000);

        //set up mesh
        File meshTxt = new File("cube.txt");
        Mesh mesh = new Mesh(meshTxt);
        //IT WORKS
        System.out.println(mesh.getTriangles().get(4).getVertices()[2].getZ());

        // now it's time for triangle work
        // iterate through ever triangle
        for(Triangle triangle : mesh.getTriangles()){
            //object space to world space
            // rotation, scale, then translation

            //transform vertices to camera space
            // translation, then rotation

            //multiply by projection matrix
        }


        //done!
        frame.setVisible(true);
    }
}
