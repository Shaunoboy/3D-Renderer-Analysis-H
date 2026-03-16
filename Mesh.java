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

    public void txtToTriangles(File meshTxt) throws FileNotFoundException {
        Scanner text = new Scanner(meshTxt);

        int numDoubles = 0;
        double[] vertexCoords = new double[3];
        Vertex[] verticesTemp = new Vertex[3];
        while (text.hasNext()){
            if(numDoubles % 3 == 0 && numDoubles != 0){
                if(numDoubles % 9 == 0){
                    verticesTemp[0] = new Vertex(vertexCoords[0],vertexCoords[1],vertexCoords[2]);
                }
                else if(numDoubles % 9 == 0){
                    verticesTemp[0] = new Vertex(vertexCoords[0],vertexCoords[1],vertexCoords[2]);
                }
            }

            if(numDoubles % 9 == 0 && numDoubles != 0){
                triangles.add(new Triangle(verticesTemp));
            }

            if(text.hasNextDouble()){
                System.out.println(text.nextDouble());
                numDoubles += 1;
            }
            else{
                text.next();
            }
        }
    }

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
