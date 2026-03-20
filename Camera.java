public class Camera {
    double posX;
    double posY;
    double posZ;
    // rotations are relative to itself NOT the world space
    double rotX;
    double rotY;
    double rotZ;
    double FOV;

    // variables used for projection matrix
    double zFar;
    double zNear;



    public Camera(double x, double y, double z, double FOV, double rotx, double roty, double rotz, double far, double near){
        posX = x;
        posY = y;
        posZ = z;
        rotX = rotx;
        rotY = roty;
        rotZ = rotz;
        this.FOV = FOV;
        this.zFar = far;
        this.zNear = near;
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
    public double[] getRot(){
        return new double[]{rotX, rotY, rotZ};
    }
    public double getFOV(){
        return FOV;
    }
    public double getzFar(){
        return zFar;
    }
    public double getzNear(){
        return zNear;
    }

}
