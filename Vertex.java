public class Vertex {
    double x;
    double y;
    double z;
    double magnitude;

    public Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vertex(){
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public double getX(){
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ(){
        return z;
    }
}
