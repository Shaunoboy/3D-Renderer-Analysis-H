import java.util.*;

public class Mesh {
    ArrayList<Triangle> triangles = new ArrayList<>();
    double rotX;
    double rotY;
    double rotZ;

    public Mesh(Triangle... triangles){
        this.triangles.addAll(Arrays.asList(triangles));
    }

    public Mesh(ArrayList<Triangle> triangles){
        this.triangles.addAll(triangles);
    }
}
