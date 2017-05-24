package pers.Sort;


import java.util.Random;

/**
 * Created by Wu on 2017/3/29.
 */
public class Randomized_Quicksort {
    public static void randomized_Quicksort(int[] arry, int first, int last){
        if (first < last){
            int q = Randomized_Partition(arry,first,last);
            randomized_Quicksort(arry,first,q-1);
            randomized_Quicksort(arry,q+1,last);
        }
    }
    private static int Randomized_Partition(int[] arry,int first, int last){
        Random random = new Random(10);
        int i = random.nextInt(last+1-first) + first;
        int temp = arry[first];
        arry[first] = arry[last];
        arry[last] = temp;
        return Partition(arry,first,last);
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
