package pers.Sort;

/**
 * Created by Wu on 2017/3/29.
 */
public class Quicksort {
    public static void quicksort(int[] arry,int first,int last){
        if(first < last){
            int q = Partition(arry,first,last);
            quicksort(arry,first,q - 1);
            quicksort(arry,q + 1,last);
        }
    }
    private static int Partition(int[] arry, int first, int last){
        int i = first - 1;
        int x = arry[last];
        for(int j = first;j <= last - 1; j++){
            if(arry[j] <= x){
                i = i + 1;
                int temp = arry[i];
                arry[i] = arry[j];
                arry[j] = temp;
            }
        }
        int temp = arry[i + 1];
        arry[i + 1] = arry[last];
        arry[last] = temp;
        return i+1;
    }
}
