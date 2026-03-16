import java.awt.*;

public class Triangle {
    Vertex[] vertices = new Vertex[3];
    Color color;

    public Triangle(Vertex v1, Vertex v2, Vertex v3){
        vertices[0] = v1;
        vertices[1] = v2;
        vertices[2] = v3;
        color = Color.GRAY;
    }

    public Triangle(Vertex[] vertices){
        this.vertices = vertices;
        color = Color.GRAY;
    }

    public Triangle(Vertex v1, Vertex v2, Vertex v3, Color color){
        vertices[0] = v1;
        vertices[1] = v2;
        vertices[2] = v3;
        this.color = color;
    }

    public Vertex[] getVertices(){
        return vertices;
    }

    public void setVertices(Vertex new1, Vertex new2, Vertex new3){
        vertices[0] = new1;
        vertices[1] = new2;
        vertices[2] = new3;
    }
}
