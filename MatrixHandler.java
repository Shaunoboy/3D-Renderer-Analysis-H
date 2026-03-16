public class MatrixHandler {

    //matrices should look like this {{}}
    public static Vertex vertexMultiplication(Vertex vertex, double[][] matrix){
        double[][] vertexMat = {vertex.getArr()};
        vertexMat = matrixMultiplication(vertexMat, matrix);

        Vertex result = new Vertex(vertexMat[0]);
        return result;
    }

    public static double[][] findCameraSpaceMatrix(Camera camera, Vertex vertex){
        return null;
    }

    public static double[][] findProjectionMatrix(Camera camera, Vertex vertex){
        return null;
    }

    public static double[][] findWorldSpaceMatrix(Mesh mesh, Vertex vertex){
        return null;
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
    public static double[][] matrixMultiplication(double[][] matrix1, double[][] matrix2){
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
