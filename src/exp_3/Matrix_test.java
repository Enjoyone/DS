package exp_3;


import exp_3.Sparse_Matrix.LinkedMatrix;
import exp_3.Sparse_Matrix.Triple;

public class Matrix_test {
    public static void main(String[] args) {
        Triple[] elemsa={new Triple(0,2,11),new Triple(0,4,17)
                ,new Triple(1,1,20),new Triple(3,0,19),
                new Triple(3,2,36), new Triple(3,5,28),
                new Triple(4,2,50)};
        LinkedMatrix mata=new LinkedMatrix(5,6,elemsa);
        System.out.println(mata.toString());
        //mata.printMatrix();
        mata.transpose();
    }
}
