package exp_3.Sort_find;

import java.util.Arrays;
import java.util.Random;

public  class sortF {
    //产生随机数
    public int[] random(){
        int a[]=new int[20];
        Random random=new Random();
        for(int i=0; i<a.length; i++) {
            a[i]=random.nextInt(100)+ 1;
        }
        return a;
    }
    //并统计在各种排序方法中关键字的比较次数，最后输出各类排序方法的排序结果及关键字的比较次数。

    //直接插入排序
    public void straight_insertion(){


    }


    //直接选择排序



    //快速排序








//        c)	用折半查找法在前面的已排好序的数据表上查找，是否有此数，如有，输出其序号。如没有，在屏幕给出提示信息。

    public static void main(String[] args) {
        int b[]=new sortF().random();
        System.out.println("获取1-100随机数："+ Arrays.toString(b));











    }

}