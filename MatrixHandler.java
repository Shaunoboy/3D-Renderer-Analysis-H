public class MatrixHandler {

    //matrices should look like this {{}}
    public static Vertex vertexMultiplication(Vertex vertex, double[][] matrix){
        Vertex result = new Vertex();


        return null;
    }

    public static double[][] findCameraSpaceMatrix(Camera camera, Vertex vertex){
        return null;
    }
    //matrices look like this; double[row][col]
    /*{{x,y,z}
        {x,y,z}
        {x,y,z}
            }
    *///matrix 2 multiplies onto matrix 1  M1 * M2; m2
    public static double[][] matrixMultiplication(double[][] matrix1, double[][] matrix2){
        //check if possible
        int m1ColLength = matrix1[0].length; // m1 columns length
        int m2RowLength = matrix2.length;    // m2 rows length
        if(m1ColLength != m2RowLength) return null;
        //check for resulting matrix size
        int resultColLength;

        return null;
    }

}
