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

        int numDoubles = 0;
        double[] vertexCoords = new double[3];
        Vertex[] verticesTemp = new Vertex[3];
        while (text.hasNext()){
            //if(numDoubles % 3 == 0 && numDoubles != 0){
                if(numDoubles % 9 == 3){
                    verticesTemp[0] = new Vertex(vertexCoords);
                }
                else if(numDoubles % 9 == 6){
                    verticesTemp[1] = new Vertex(vertexCoords);
                }
                else if(numDoubles % 9 == 0){
                    verticesTemp[2] = new Vertex(vertexCoords);
                    triangles.add(new Triangle(verticesTemp));
                }
           // }


            if(text.hasNextDouble()){
                double number = text.nextDouble();
                //System.out.println(number);
                vertexCoords[numDoubles%3] = number;
                numDoubles += 1;
            }
            else{
                text.next();
            }
        }
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
        rotX += x;
        rotY += y;
        rotZ += z;
        if(rotX >= 360) rotX -= 360;
        if(rotY >= 360) rotY -= 360;
        if(rotZ >= 360) rotZ -= 360;
    }
    public void setScale(double x, double y, double z){
        scaleX *= x;
        scaleY *= y;
        scaleZ *= z;
    }
    public void setPosition(double x, double y, double z){
        posX *= x;
        posY *= y;
        posZ *= z;
    }

}
