package Knapsack;

/**
 * Created by Wu on 2017/4/22.
 */
public class Fraction_Knapsack {
    public Fraction_Knapsack(int[][] s, int w){
        items = new double[s.length][s[0].length + 1];
        for(int j = 0; j < s.length; j++){
            items[j][0] = s[j][0];
            items[j][1] = s[j][1];
            items[j][2] = s[j][2];
        }
        maxweight = w;
        for(int i = 0; i < items.length; i++){
            items[i][s[0].length] = items[i][2] / items[i][1];
        }
        itemMergeSort(0,items.length - 1);
        findSolution();
    }

    private double[][]  items;
    private int maxweight;
    private double value;
    private void findSolution(){
        int i, weight = maxweight;
        value = 0;
        for(i = 0; i < items.length; i++){
            items[i][3] = 0;
        }
        for(i = 0; i < items.length; i++){
            if(items[i][1] <= weight){
                weight = weight - (int)items[i][1];
                items[i][3] = 1;
                value = value + items[i][2];
                continue;
            }
            else{
                items[i][3] = weight / items[i][1];
                value = value + items[i][2] * items[i][3];
                break;
            }
        }
    }
    private void itemMergeSort(int i, int j){
        if(i < j) {
            int tmp = (i + j) / 2;
            itemMergeSort(i,tmp);
            itemMergeSort(tmp + 1,j);
            Sort(i, tmp, j);
        }
    }
    private void Sort(int first,int mid, int last){
        double[][] t = new double[items.length][items[0].length];
        int i = first, m = mid + 1;
        int k = 0;
        while (i <= mid && m <= last){
            if(items[i][3] >= items[m][3]){
                t[k++] = items[i++];
            }
            else if(items[i][3] < items[m][3]){
                t[k++] = items[m++];
            }
        }
        while (i <= mid){
            t[k++] = items[i++];
        }
        while (m <= last){
            t[k++] = items[m++];
        }
        for(i = first,k = 0; i < last - first + 1;){
            items[i++] = t[k++];
        }
    }
    public void printSolution(){
        System.out.println("Item       Weight      Value       Percentage");
        for(int i = 0; items[i][3] != 0 && i < items.length; i++){
            System.out.printf((char)items[i][0] + "          %-2d          %-3d         %4f\n",(int)items[i][1],(int)items[i][2], items[i][3]);
        }
        System.out.println("Max value is " + value);
    }

    public double getValue(){return value;}
}
