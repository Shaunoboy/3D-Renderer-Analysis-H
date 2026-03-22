public class Vertex {
    double x;
    double y;
    double z;
    double w;
    double magnitude;

    //here?
    double focalLength = 1.0;

    public Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    }
    public Vertex(){
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.w = 1;
    }
    public Vertex(double[] coords){
        this.x = coords[0];
        this.y = coords[1];
        this.z = coords[2];
        if(coords.length == 4){
            this.w = coords[3];
        }
        else{
            this.w = 1;
        }
    }

    //what does this do?
    public int vertexToProjX() {
        return (int) ((x * (focalLength)/(focalLength / z)));
    }
    public int vertexToProjY() {
        return (int) ((y * (focalLength)/(focalLength / z)));
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
    public double getW(){
        return w;
    }

    public double[] getArr(){
        return new double[]{x, y, z, w};
    }

    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setZ(double z){
        this.z = z;
    }
    public void setW(double w){
        this.w = w;
    }

    public String toString(){
        return "{"+x+","+y+","+z+","+w+"}";

    }
}
