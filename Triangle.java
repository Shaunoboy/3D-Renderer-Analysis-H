import java.awt.*;

public class Triangle {
    Vector3 vertex1;
    Vector3 vertex2;
    Vector3 vertex3;
    Color color;

    public Triangle(Vector3 v1, Vector3 v2, Vector3 v3){
        vertex1 = v1;
        vertex2 = v2;
        vertex3 = v3;
        color = Color.GRAY;
    }

    public Triangle(Vector3 v1, Vector3 v2, Vector3 v3, Color color){
        vertex1 = v1;
        vertex2 = v2;
        vertex3 = v3;
        this.color = color;
    }

}
