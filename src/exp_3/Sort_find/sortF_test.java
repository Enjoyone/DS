package exp_3.Sort_find;

import exp_3.Sort_find.sortF;

import java.util.Arrays;

public class sortF_test {
    public static void main(String[] args) {
        int b[]=new sortF().random();

        System.out.println("获取1-100随机数："+ Arrays.toString(b));


        sortF.straight_insertion(b);   //直接插入排序
        sortF.QuickSort(b);        //快速排序
        //sortF.selectSort(b);           //选择排序
        int []c=sortF.selectSort(b);
        //System.out.println(Arrays.toString(c));
        System.out.println("查找30：");
        sortF.binarySearch(c,30);










    }

}
