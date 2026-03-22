import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class GraphicsPanel extends JPanel {
    GraphicsPanel(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.black);
        g2D.fillRect(0,0,getWidth(),getHeight());
        g2D.setColor(Color.white);

        //set up camera
        Camera camera = new Camera(0.5,3,3,90,23,0,0,0.1,1000);

        File meshTxt = new File("cube.txt");
        Mesh mesh = null;
        try {
            mesh = new Mesh(meshTxt);
            mesh.setPosition(0,0,10);
            mesh.setScale(1,1,1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(mesh.getTriangles().size());

        double[][] toWorldSpace = MatrixHandler.findWorldSpaceMatrix(mesh);
        System.out.println("\n"+ Arrays.toString(toWorldSpace[0]));
        System.out.println(Arrays.toString(toWorldSpace[1]));
        System.out.println(Arrays.toString(toWorldSpace[2]));
        System.out.println(Arrays.toString(toWorldSpace[3])+ "\n");
        double[][] toCameraSpace = MatrixHandler.findCameraSpaceMatrix(camera);
        System.out.println("\n"+ Arrays.toString(toCameraSpace[0]));
        System.out.println(Arrays.toString(toCameraSpace[1]));
        System.out.println(Arrays.toString(toCameraSpace[2]));
        System.out.println(Arrays.toString(toCameraSpace[3])+ "\n");
        double[][] projMatrix = MatrixHandler.findProjectionMatrix(camera,this);
        System.out.println("\n"+ Arrays.toString(projMatrix[0]));
        System.out.println(Arrays.toString(projMatrix[1]));
        System.out.println(Arrays.toString(projMatrix[2]));
        System.out.println(Arrays.toString(projMatrix[3])+ "\n");


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
                //vers[i] = new Vertex(MatrixHandler.verMult(triangle.vertices[i],toWorldSpace).getArr());
                //System.out.println(vers[i].getX() + " " + vers[i].getY()+ " " + vers[i].getZ()+ " " + vers[i].getW());
                //transform vers to camera space
                // translation, then rotation
                //System.out.println(triangle.vertices[i].toString());
                vers[i] = new Vertex(MatrixHandler.verMult(triangle.vertices[i],toCameraSpace).getArr());
                //System.out.println(vers[i].toString());
                //multiply by projection matrix
                vers[i] = new Vertex(MatrixHandler.verMult(vers[i],projMatrix).getArr());
                //complete the projection
                //System.out.println(vers[i].toString());
                vers[i].setX( (vers[i].getX()/vers[i].getW()  + 1) * (double) getWidth() * 0.5);
                vers[i].setY( (vers[i].getY()/vers[i].getW()  + 1) * (double) getHeight() * 0.5);

                //System.out.println(vers[i].toString() + "\n");
            }
            System.out.println( "(" + (int) vers[0].getX()+"," +(int) vers[0].getY()+")(" + (int) vers[1].getX()+"," + (int) vers[1].getY()+")");
            System.out.println("(" +(int) vers[1].getX()+"," + (int) vers[1].getY()+")(" + (int) vers[2].getX()+"," + (int) vers[2].getY()+")");
            System.out.println("(" +(int) vers[0].getX()+"," + (int) vers[0].getY()+")(" + (int) vers[2].getX()+"," + (int) vers[2].getY()+")");


            g2D.drawLine((int) vers[0].getX(), (int) vers[0].getY(), (int) vers[1].getX(), (int) vers[1].getY());
            g2D.drawLine((int) vers[1].getX(), (int) vers[1].getY(), (int) vers[2].getX(), (int) vers[2].getY());
            g2D.drawLine((int) vers[0].getX(), (int) vers[0].getY(), (int) vers[2].getX(), (int) vers[2].getY());
        }

    }

}
