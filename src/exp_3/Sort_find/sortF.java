package exp_3.Sort_find;

import java.util.Arrays;
import java.util.Random;

public  class sortF {
    static int n1=0;   //用于测次数
    //产生随机数
    public int[] random(){
        int a[]=new int[20];
        Random random=new Random();
        for(int i=0; i<a.length; i++) {
            a[i]=random.nextInt(100)+ 1;
        }
        return a;
    }



    //直接插入排序
    public static void straight_insertion(int q[]){
        int x[]=new int[20];
        for (int i = 0; i < q.length; i++) {
            x[i]=q[i];
        }
        int num=0,sum=0;
        System.out.println("直接插入排序（升序）");
        for (int i=1; i<x.length; i++)                  //n-1趟扫描，依次向前插入n-1个数
        {
            int temp = x[i], j;                           //每趟将keys[i]插入到前面排序子序列中
            for (j = i - 1; j >= 0 && temp < x[j]; j--,num++) {        //升序
//            for (j=i-1; j>=0 && temp>keys[j]; j--)         //降序
                x[j + 1] = x[j];
               // num++;
            }                      //将前面较大元素向后移动
            x[j + 1] = temp;//temp值到达插入位置
            num++;
            //System.out.print("第" + i + "趟 temp=" + temp + "\t");

        }
        System.out.print(Arrays.toString(x));
        System.out.println("总次数：" + num+"\n");
    }


    //快速排序（升序）

    public static void QuickSort (int []a)
    {
        int L[]=new int[21];
        for (int i = 1; i <=a.length; i++) {
            L[i]=a[i-1];
        }
        //System.out.println(L[0]);
        System.out.println("快速排序（升序）");
        QSort(L, 1, L.length-1);
        for (int i = 1; i < L.length; i++) {
            System.out.print(L[i]+",");
        }
        System.out.println("比较次数："+n1);

    }

    public static void  QSort ( int []L,int low,int high ){
        //System.out.println(low);
        if (low<high){
            int n1;
            n1=Partition(L,low,high);
            QSort(L,low,n1-1);
            QSort(L,n1+1,high);
        }
    }

    public static int  Partition ( int []L,int low, int high ){
        //System.out.println("q"+low);
        L[0]=L[low];
        int m1=L[low];
        while (low<high){
            while (low<high&&L[high]>=m1){
                --high;
                n1++;
            }

            L[low]=L[high];
            while (low<high&&L[low]<=m1){
                ++low;
                n1++;
            }
            L[high]=L[low];
        }
        L[low]=L[0];
        return low;
    }


    public static void selectSort(int[] keys)              //直接选择排序（升序）
    {
        int sum=0;
        System.out.println("直接选择排序（升序）");
        for (int i=0; i<keys.length-1; i++)                //n-1趟排序
        {
            int min=i;
            for (int j=i+1; j<keys.length; j++,sum++)            //每趟在从keys[i]开始的子序列中寻找最小元素
                if (keys[j]<keys[min])                     //（升序）

                    min = j;                              //min记住本趟最小元素下标

            if (min!=i){                                  //将本趟最小元素交换到前边
                int temp=keys[min];
                keys[min]=keys[i];
                keys[i]=temp;

            }
        }
        System.out.print(Arrays.toString(keys));
        System.out.println("比较次数："+sum);
    }






//        c)	用折半查找法在前面的已排好序的数据表上查找，是否有此数，如有，输出其序号。如没有，在屏幕给出提示信息。


}