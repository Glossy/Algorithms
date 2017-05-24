package pers.Sort;

/**
 * Created by Wu on 2017/4/12.
 */
public class LinearSort {
    public static void LinearSort(int arry[]){
        int i = 0, j = arry.length - 1;
        while (i < j){
            if (arry[i] == 1){
                while (arry[j] == 1 && i < j){ j--;}
                arry[i] = 0;
                arry[j] = 1;
            }
            i++;
        }
    }
}
