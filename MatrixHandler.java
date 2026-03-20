import javax.swing.*;

public class MatrixHandler {

    //matrices should look like this {{}}
    public static Vertex verMult(Vertex vertex, double[][] matrix){
        double[][] vertexMat = {{vertex.getX(), vertex.getY(), vertex.getZ(), 1}};
        vertexMat = matMult(vertexMat, matrix);

        Vertex result = new Vertex(vertexMat[0]);
        return result;
    }

    public static double[][] findProjectionMatrix(Camera camera, Vertex vertex, JFrame frame){
        double[][] projMatrix = {  {1,0,0,0},
                                   {0,1,0,0},
                                   {0,0,1,0},
                                   {0,0,0,1}  };

        double aspectRatio = (double) frame.getWidth()/frame.getHeight(); //placeholder value
        //setting it up
        double scale = 1 / Math.tan(Math.toRadians(camera.getFOV()) * 0.5);
        projMatrix[0][0] = aspectRatio * scale;  // scale the x coordinates of the projected point
        projMatrix[1][1] = scale;  // scale the y coordinates of the projected point 
        projMatrix[2][2] = -camera.getzFar() / (camera.getzFar()  - camera.getzNear());  // used to remap z to [0,1]
        projMatrix[3][2] = -camera.getzFar()  * camera.getzNear() / (camera.getzFar()  - camera.getzNear());  // used to remap z [0,1]
        projMatrix[2][3] = 1;  // set w = -z
        projMatrix[3][3] = 0; 

        return projMatrix;
    }

    public static double[][] findCameraSpaceMatrix(Camera camera){
        double[][] translationMatrix = {  {1,0,0,-camera.getX()},
                                    {0,1,0,-camera.getY()},
                                    {0,0,1,-camera.getZ()},
                                    {0,0,0,1}  };
        //rotations
        double xCos = Math.cos(Math.toRadians(-camera.getRotX()));
        double xSin = Math.sin(Math.toRadians(-camera.getRotX()));
        double yCos = Math.cos(Math.toRadians(-camera.getRotY()));
        double ySin = Math.sin(Math.toRadians(-camera.getRotY()));
        double zCos = Math.cos(Math.toRadians(-camera.getRotZ()));
        double zSin = Math.sin(Math.toRadians(-camera.getRotZ()));

        double[][] xRotMatrix = {  {1,0,0,0},
                                    {0,xCos,-xSin,0},
                                    {0,xSin,xCos,0},
                                    {0,0,0,1}  };
        double[][] yRotMatrix = {  {yCos,0,-ySin,0},
                                    {0,1,0,0},
                                    {ySin,0,yCos,0},
                                    {0,0,0,1}  };
        /*double[][] zRotMatrix = {  {zCos,0,-zSin,0},
                                    {0,1,0,0},
                                    {zSin,0,zCos,0},
                                    {0,0,0,1}  };*/ //z rotations are like a barrel roll
        // rotations are not communative sadly
        double[][] cameraMatrix = matMult(matMult(xRotMatrix, yRotMatrix), translationMatrix);

        return cameraMatrix;
    }

    public static double[][] findWorldSpaceMatrix(Mesh mesh){
        // apply scale first
        double[][] scaleMatrix = {  {mesh.getScaleX(),0,0,0},
                                    {0,mesh.getScaleY(),0,0},
                                    {0,0,mesh.getScaleZ(),0},
                                    {0,0,0,1}  };

        // then rotations
        double xCos = Math.cos(Math.toRadians(mesh.getRotX()));
        double xSin = Math.sin(Math.toRadians(mesh.getRotX()));
        double yCos = Math.cos(Math.toRadians(mesh.getRotY()));
        double ySin = Math.sin(Math.toRadians(mesh.getRotY()));
        double zCos = Math.cos(Math.toRadians(mesh.getRotZ()));
        double zSin = Math.sin(Math.toRadians(mesh.getRotZ()));

        double[][] xRotMatrix = {  {1,0,0,0},
                {0,xCos,-xSin,0},
                {0,xSin,xCos,0},
                {0,0,0,1}  };
        double[][] yRotMatrix = {  {yCos,0,-ySin,0},
                {0,1,0,0},
                {ySin,0,yCos,0},
                {0,0,0,1}  };
        double[][] zRotMatrix = {  {zCos,0,-zSin,0},
                {0,1,0,0},
                {zSin,0,zCos,0},
                {0,0,0,1}  };

        // then the transformation
        double[][] translationMatrix = {  {1,0,0,mesh.getX()},
                {0,1,0,mesh.getY()},
                {0,0,1,mesh.getZ()},
                {0,0,0,1}  };
        // again rotation matricies are not communative
        double[][] worldMatrix = matMult(matMult(scaleMatrix, matMult(xRotMatrix, matMult(yRotMatrix, zRotMatrix))), translationMatrix);

        return worldMatrix;
    }
    //matrices look like this; double[row][col]
    /*{{x,y,z}
        {x,y,z}
        {x,y,z}
            }
    *///matrix 2 multiplies onto matrix 1  M1 * M2; m2
    //vertex multiplicaation {{x,y,z}} * {i {x,y,z}
    //                                  j {x,y,z}
    //                                  k {x,y,z}}
    public static double[][] matMult(double[][] matrix1, double[][] matrix2){
        //check if possible
        int m1ColLength = matrix1[0].length; // m1 columns length
        int m2RowLength = matrix2.length;    // m2 rows length
        if(m1ColLength != m2RowLength) return null;

        //fetch resulting matrix size
        double[][] result = new double[matrix1.length][matrix2[0].length];

        for(int i = 0; i < matrix1.length; i++){ //first row m1
            for(int j = 0; j < matrix2[0].length; j++){ // first column m2
                for(int k = 0; k < matrix1[0].length; k++){ //iterate through the elements
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

}
