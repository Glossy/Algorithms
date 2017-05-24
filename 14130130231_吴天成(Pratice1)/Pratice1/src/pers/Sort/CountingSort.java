package pers.Sort;

/**
 * Created by Wu on 2017/4/12.
 */
public class CountingSort {
    public static void CountingSort(int arry[], int width){
        int temp[] = new int[width];
        for(int i = 0; i < width; i++){
            temp[i] = 0;
        }
        for(int i = 0; i < arry.length; i++){
            temp[arry[i] - 1]++;
        }
        for(int i = 1; i < width; i++){
            temp[i] = temp[i - 1] + temp[i];
        }
        int B[] = new int[arry.length];
        for(int i = arry.length - 1; i >= 0; i--){
            B[temp[arry[i] - 1] - 1] = arry[i];
            temp[arry[i] - 1]--;
        }
        for(int i = 0; i < arry.length; i++){
            arry[i] = B[i];
        }



    }
}
