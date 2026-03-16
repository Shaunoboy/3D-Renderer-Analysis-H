public class Camera {
    double posX;
    double posY;
    double posZ;
    double rotX;
    double rotY;
    double rotZ;
    double FOV;



    public Camera(double x, double y, double z, double FOV, double rotx, double roty, double rotz){
        posX = x;
        posY = y;
        posZ = z;
        rotX = rotx;
        rotY = roty;
        rotZ = rotz;
        this.FOV = FOV;
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

}
