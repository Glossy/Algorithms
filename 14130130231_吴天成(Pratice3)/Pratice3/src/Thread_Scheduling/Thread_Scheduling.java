package Thread_Scheduling;

/**
 * Created by Wu on 2017/4/23.
 */
public class Thread_Scheduling {
    public Thread_Scheduling(int[] t){
        runningtime = t;
        MergeSort(0,runningtime.length - 1);
        getMincompletiontime();
    }

    private int[] runningtime;
    private int mincompletiontime;

    private void MergeSort(int first, int last){
        if(first < last){
            int mid = (first + last)/2;
            MergeSort(first, mid);
            MergeSort(mid + 1,last);
            Sort(first,mid,last);
        }
    }
    private void Sort(int first, int mid, int last){
        int i = first, j = mid + 1;
        int[] t = new int[last - first + 1];
        int k = 0;
        while (i <= mid && j <= last){
            if(runningtime[i] <= runningtime[j]){
                t[k++] = runningtime[i++];
            }
            else {
                t[k++] = runningtime[j++];
            }
        }
        while (i <= mid){
            t[k++] = runningtime[i++];
        }
        while (j <= last){
            t[k++] = runningtime[j++];
        }
        k = 0;
        while (k < t.length){
            runningtime[first + k] = t[k];
            k++;
        }
    }
    public void printScheduling(){
        System.out.print("The min average completion time is ");
        for(int i = 0; i < runningtime.length; i++){
            System.out.print(runningtime[i] + " ");
        }
        System.out.print("\n");
        System.out.println("Min averate completion time is " + mincompletiontime / runningtime.length);
    }
    public int getMincompletiontime(){
        int i;
        int t = 0;
        int[] sum = new int[runningtime.length + 1];
        for(i = 0; i < runningtime.length; i++){
            sum[i + 1] = sum[i] + runningtime[i];
        }
        for(i = 1; i < sum.length; i++){
            t = sum[i] + t;
        }
        mincompletiontime = t;
        return mincompletiontime;
    }
}
