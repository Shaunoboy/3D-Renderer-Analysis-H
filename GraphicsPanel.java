import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class GraphicsPanel extends JPanel {

    public JSlider xPosSlider;
    public JSlider xRotSlider;
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
        Camera camera = new Camera(0.5,0.5,0+pos/500,70,rot,0,0,1000,0.1);

        File meshTxt = new File("cube.txt");
        Mesh mesh = null;
        try {
            mesh = new Mesh(meshTxt);
            mesh.setPosition(0,0,0);
            mesh.setScale(1,1,2);
            mesh.setRotate(0,30,0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(mesh.getTriangles().size());

        double[][] toWorldSpace = MatrixHandler.findWorldSpaceMatrix(mesh);
            /*System.out.println("\n"+ Arrays.toString(toWorldSpace[0]));
            System.out.println(Arrays.toString(toWorldSpace[1]));
            System.out.println(Arrays.toString(toWorldSpace[2]));
            System.out.println(Arrays.toString(toWorldSpace[3])+ "\n");*/
        double[][] toCameraSpace = MatrixHandler.findCameraSpaceMatrix(camera);
        double[][] projMatrix = MatrixHandler.findProjectionMatrix(camera,this);


        int count = 0;
        for(Triangle triangle : mesh.getTriangles()){
            count++;
            System.out.println(count);
            System.out.println(getWidth() + "width X height" + getHeight());
            System.out.println(triangle.toString());
            //changed vertex into the screen
            Vertex[] vers = new Vertex[3];

            for(int i = 0; i < 3; i++) {

                //object space to world space
                // rotation, scale, then translation
                vers[i] = new Vertex(MatrixHandler.verMult(triangle.vertices[i],toWorldSpace).getArr());
                System.out.println(vers[i].getX() + " " + vers[i].getY()+ " " + vers[i].getZ()+ " " + vers[i].getW());
                //transform vers to camera space
                // translation, then rotation
                //System.out.println(triangle.vertices[i].toString());
                vers[i] = new Vertex(MatrixHandler.verMult(vers[i],toCameraSpace).getArr());
                //System.out.println(vers[i].toString());
                //multiply by projection matrix
                vers[i] = new Vertex(MatrixHandler.verMult(vers[i],projMatrix).getArr());

                //scale into view
                vers[i].setX( (vers[i].getX()/vers[i].getW()  + 1) * (double) getWidth() * 0.5);
                vers[i].setY( (vers[i].getY()/vers[i].getW()  + 1) * (double) getHeight() * 0.5);
                vers[i].setZ( (vers[i].getZ()/vers[i].getW()));
                System.out.println(vers[i].toString());

                //System.out.println(vers[i].toString() + "\n");
            }

            //check z
            if(vers[0].getZ() > 0 && vers[0].getZ() <= 1 && vers[1].getZ() > 0 && vers[1].getZ() <= 1 && vers[2].getZ() > 0 && vers[2].getZ() <= 1){
                g2D.setColor(Color.white);
                g2D.drawLine((int) vers[0].getX(), (int) vers[0].getY(), (int) vers[1].getX(), (int) vers[1].getY());
                g2D.drawLine((int) vers[1].getX(), (int) vers[1].getY(), (int) vers[2].getX(), (int) vers[2].getY());
                g2D.drawLine((int) vers[0].getX(), (int) vers[0].getY(), (int) vers[2].getX(), (int) vers[2].getY());
                //draw points
                g2D.setColor(Color.red);
                g2D.fillRect((int) vers[0].getX(), (int) vers[0].getY(), 5, 5);
                g2D.fillRect((int) vers[2].getX(), (int) vers[2].getY(), 5, 5);
                g2D.fillRect((int) vers[1].getX(), (int) vers[1].getY(), 5, 5);
            }

        }

    }

}
