package exp_3.Sparse_Matrix;

import exp_3.Sparse_Matrix.SeqSparseMatrix;
import exp_3.Sparse_Matrix.Triple;

public class Matrix_test {
    public static void main(String[] args) {
        Triple[] elemsa={new Triple(0,2,11),new Triple(0,4,17)
                ,new Triple(1,2,20),new Triple(3,0,19),
                new Triple(3,2,36), new Triple(3,5,28),
                new Triple(4,2,50)};
        //LinkedMatrix mata=new LinkedMatrix(5,6,elemsa);
        SeqSparseMatrix mat=new SeqSparseMatrix(5,6,elemsa);
        //System.out.println(mat.get(3,4));
        //System.out.println(mat.toString());
        mat.print(mat);
        mat.fasttranstri(mat);

    }



}