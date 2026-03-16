import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Renderer {
    public static void main(String[] args){

        JFrame frame = new JFrame();
        Camera camera = new Camera(1,1,1,90,0,0,0);
        //Mesh data
        //unit cube
        //front
        //{ {{0,0,0},{0,1,0}},{1,0,0}},
        //  {{1,1,0},{0,1,0},{1,0,0}},
        //right
        //  {{1,0,0},{1,1,0},{1,0,1}},
        //  {{1,1,1},{1,1,0},{1,0,1}},
        //left
        //  {{0,0,1},{0,1,1},{0,0,0}},
        //  {{0,1,0},{0,1,1},{0,0,0}},
        //back
        //  {{1,0,1},{1,1,1},{0,0,1}},
        //  {{0,1,1},{1,1,1},{0,0,1}},
        //top
        //  {{0,1,0},{0,1,1},{1,1,0}},
        //  {{1,1,1},{0,1,1},{1,1,0}},
        //bottom
        //  {{0,0,0},{1,0,0},{0,0,1}},
        //  {{1,0,1},{1,0,0},{0,0,1}} }
        Mesh mesh = new Mesh();

        //transform vertices to camera space

        //multiply by projection matrix

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
