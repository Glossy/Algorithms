package Max_Sum;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Created by Wu on 2017/4/19.
 */
public class Max_Sum {
    public Max_Sum(int[] a){
        arry = a;
        subarry = new int[2];
        maxsum = a[0];
    }
    private int[] arry;
    private int[] subarry;
    private int maxsum;

    public int getMaxsum(){
        int i,j,length,temp;
        for(length = 1; length <= arry.length; length++){
            for(i = 0; i + length -1< arry.length; i++){
                if(length == 1){
                    maxsum = max(arry[i],maxsum);
                    subarry[0] = i;
                    subarry[1] = i;
                    continue;
                }
                for(j = i; j + 1 < arry.length; j++){
                    temp = 0;
                    for(int s = i; s <= j; s++){
                       temp = temp + arry[s];
                    }
                    maxsum = max(temp,maxsum);
                    subarry[0] = i;
                    subarry[1] = j;
                }
            }
        }
        return maxsum;
    }
    public int[] getSubarry() {
        return subarry;
    }
}
