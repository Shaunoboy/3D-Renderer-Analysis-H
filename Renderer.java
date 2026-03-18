import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Renderer {
    //dw abt this, checking if matrix multipication works
    public static String toString(double[][] m) {
        String result = "";
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                result += String.format("%11.2f", m[i][j]);
            }
            result += "\n";
        }
        return result;
    }
    

    public static void main(String[] args) throws FileNotFoundException {

        //again checking if matrix works
        double[][] multiplicand = new double[][] {
                {3, -1, 2},
                {2,  0, 1},
                {1,  2, 1}
        };
        double[][] multiplier = new double[][] {
                {2, -1, 1},
                {0, -2, 3},
                {3,  0, 1}
        };
        System.out.println(toString(MatrixHandler.matrixMultiplication(multiplicand, multiplier)));

        //actual code now

        //set up frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);

        //set up camera
        Camera camera = new Camera(1,1,1,90,0,0,0);

        //set up mesh
        File meshTxt = new File("cube.txt");
        Mesh mesh = new Mesh(meshTxt);
        //IT WORKS
        System.out.println(mesh.getTriangles().get(4).getVertices()[2].getZ());

        // now it's time for triangle work
        // iterate through ever triangle
        for(Triangle triangle : mesh.getTriangles()){

        }
        //object space to world space
        // rotation, scale, then translation

        //transform vertices to camera space
        // translation, then rotation

        //multiply by projection matrix

        //done!
        frame.setVisible(true);
    }
}
