import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Renderer {
    public static void main(String[] args){

        JFrame frame = new JFrame();
        Camera camera = new Camera(1,1,1, 90);
        //Mesh is hardcoded dw abt that
        ArrayList<Triangle> mesh = new ArrayList<>();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
