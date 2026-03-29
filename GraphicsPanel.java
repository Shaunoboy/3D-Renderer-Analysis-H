import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class GraphicsPanel extends JPanel {

    private JSlider xPosSlider;
    private JSlider xRotSlider;
    GraphicsPanel(JSlider xPosSlider, JSlider xRotSlider){
        this.xPosSlider = xPosSlider;
        this.xRotSlider = xRotSlider;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.black);
        g2D.fillRect(0,0,getWidth(),getHeight());
        g2D.setColor(Color.white);

        //slider thigns
        double pos = (double) xPosSlider.getValue();
        double rot = (double) xRotSlider.getValue();
        //set up camera
        Camera camera = new Camera(0.5,0.5,-3+pos/50,70,-rot,0,0,100,0.1);

        File meshTxt = new File("cube.txt");

        Mesh mesh = null;
        try {
            mesh = new Mesh(meshTxt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        mesh.setPosition(0,0,0);
        mesh.setScale(1,1,1);
        mesh.setRotate(30,30,0);
        mesh.drawMesh(camera, this, g2D);
/*
        Mesh mesh2 = null;
        try {
            mesh2 = new Mesh(meshTxt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        mesh2.setPosition(0,1.2,0);
        mesh2.setScale(1,1,1);
        mesh2.setRotate(0,45,0);
        mesh2.drawMesh(camera, this, g2D);

        Mesh mesh3 = null;
        try {
            mesh3 = new Mesh(meshTxt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        mesh3.setPosition(0,-1.2,0);
        mesh3.setScale(1,1,1);
        mesh3.setRotate(0,45,0);
        mesh3.drawMesh(camera, this, g2D);*/
    }

}
