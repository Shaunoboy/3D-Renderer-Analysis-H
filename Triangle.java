import java.awt.*;

public class Triangle {
    Vertex vertex1;
    Vertex vertex2;
    Vertex vertex3;
    Color color;

    public Triangle(Vertex v1, Vertex v2, Vertex v3){
        vertex1 = v1;
        vertex2 = v2;
        vertex3 = v3;
        color = Color.GRAY;
    }

    public Triangle(Vertex v1, Vertex v2, Vertex v3, Color color){
        vertex1 = v1;
        vertex2 = v2;
        vertex3 = v3;
        this.color = color;
    }

}
