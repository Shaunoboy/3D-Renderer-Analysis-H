import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mesh {
    ArrayList<Triangle> triangles = new ArrayList<>();
    double rotX;
    double rotY;
    double rotZ;
    double posX;
    double posY;
    double posZ;
    double scaleX;
    double scaleY;
    double scaleZ;

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

}
