import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mesh {
    ArrayList<Triangle> triangles = new ArrayList<>();
    private double rotX;
    private double rotY;
    private double rotZ;
    private double posX;
    private double posY;
    private double posZ;
    private double scaleX;
    private double scaleY;
    private double scaleZ;

    public Mesh(Triangle... triangles){
        this.triangles.addAll(Arrays.asList(triangles));
    }
    public Mesh(ArrayList<Triangle> triangles){
        this.triangles.addAll(triangles);
    }
    public Mesh(File meshTxt) throws FileNotFoundException {
        txtToTriangles(meshTxt);
    }

    public void txtToTriangles(File meshTxt) throws FileNotFoundException {
        Scanner text = new Scanner(meshTxt);

        int count = 0;
        double[] vertexCoords = new double[3];
        Vertex[] verticesTemp = new Vertex[3];

        while (text.hasNext()) {

            if (text.hasNextDouble()) {
                double number = text.nextDouble();

                vertexCoords[count % 3] = number;
                count++;

                // Every 3 numbers → make a vertex
                if (count % 3 == 0) {
                    Vertex v = new Vertex(
                            vertexCoords[0],
                            vertexCoords[1],
                            vertexCoords[2]
                    );

                    verticesTemp[(count / 3 - 1) % 3] = v;
                }

                // Every 9 numbers → make a triangle
                if (count % 9 == 0) {
                    triangles.add(new Triangle(
                            verticesTemp[0],
                            verticesTemp[1],
                            verticesTemp[2]
                    ));
                }

            } else {
                text.next(); // skip non-numbers
            }
        }

        text.close();
    }

    //gets
    public ArrayList<Triangle> getTriangles(){
        return triangles;
    }
    public double getX(){
        return posX;
    }
    public double getY() {
        return posY;
    }
    public double getZ(){
        return posZ;
    }
    public double[] getPos() {
        return new double[]{posX, posY, posZ};
    }
    public double getRotX(){
        return rotX;
    }
    public double getRotY(){
        return rotY;
    }
    public double getRotZ(){
        return rotZ;
    }
    public double[] getRot() {
        return new double[]{rotX, rotY, rotZ};
    }
    public double getScaleX(){
        return scaleX;
    }
    public double getScaleY(){
        return scaleY;
    }
    public double getScaleZ(){
        return scaleZ;
    }
    public double[] getScale() {
        return new double[]{scaleX, scaleY, scaleZ};
    }

    //sets
    public void setRotate(double x, double y, double z){
        rotX = x;
        rotY = y;
        rotZ = z;
        if(rotX >= 360) rotX -= 360;
        if(rotY >= 360) rotY -= 360;
        if(rotZ >= 360) rotZ -= 360;
        if(rotX < 0) rotX = 360 - rotX;
        if(rotY < 0) rotY = 360 - rotY;
        if(rotZ < 0) rotZ = 360 - rotZ;
    }
    public void setScale(double x, double y, double z){
        scaleX = x;
        scaleY = y;
        scaleZ = z;
    }
    public void setPosition(double x, double y, double z){
        posX = x;
        posY = y;
        posZ = z;
    }

    public void drawMesh(Camera camera, GraphicsPanel gPanel, Graphics2D g2D){
        double[][] toWorldSpace = MatrixHandler.findWorldSpaceMatrix(this);
        double[][] toCameraSpace = MatrixHandler.findCameraSpaceMatrix(camera);
        double[][] projMatrix = MatrixHandler.findProjectionMatrix(camera,gPanel);


        int count = 0;
        for(Triangle triangle : getTriangles()){
            count++;
            //changed vertex into the screen
            Vertex[] vers = new Vertex[3];

            for(int i = 0; i < 3; i++) {
                vers[i] = new Vertex(MatrixHandler.verMult(MatrixHandler.verMult(MatrixHandler.verMult(triangle.getVertices()[i], toWorldSpace), toCameraSpace), projMatrix).getArr());

                //scale into view
                vers[i].setX( (vers[i].getX()/Math.abs(vers[i].getW())  + 1) * (double) gPanel.getWidth() * 0.5);
                vers[i].setY( (vers[i].getY()/Math.abs(vers[i].getW())  + 1) * (double) gPanel.getHeight() * 0.5);
                vers[i].setZ( (vers[i].getZ()/Math.abs(vers[i].getW())));
            }

            //check z
            if(vers[0].getZ() > 0 && vers[0].getZ() <= 1 && vers[1].getZ() > 0 && vers[1].getZ() <= 1 && vers[2].getZ() > 0 && vers[2].getZ() <= 1){
                g2D.setColor(Color.white);
                g2D.setStroke(new BasicStroke(3));
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
