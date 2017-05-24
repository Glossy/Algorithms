package pers.Sort;

/**
 * Created by Wu on 2017/3/28.
 */
public class MergeSort {
    public static void MergeSort(int[] arry, int first, int last){
        int mid = (first + last) / 2;
        if(first < last){
            MergeSort(arry,first,mid);
            MergeSort(arry,mid+1,last);
            Sort(arry,first,mid,last);
        }
    }
    private static void Sort(int[] arry, int first, int mid, int last){
        int i = first, j = mid+1;
        int k =0;
        int[] temp = new int[last - first + 1];
        while(i <= mid && j <= last){
            if(arry[i] < arry[j]){
                temp[k++] = arry[i++];
            }
            if(arry[i] >= arry[j]){
                temp[k++] = arry[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arry[i++];
        }
        while(j <= last){
            temp[k++] = arry[j++];
       }
       for(k = 0;k < (last - first) + 1;k++){
            arry[first + k] = temp[k];
       }
    }
    public static boolean FindSubArry(int[] arry,int first, int last, int addtion){
        int i = first, j = last;
        while(i != j){
            if(arry[i] + arry[j] < addtion){ i++;}
            if(arry[i] + arry[j] > addtion){ j--;}
            if(arry[i] + arry[j] == addtion){
                return true;
            }
        }
        return false;
    }
}
