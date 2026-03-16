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


}
