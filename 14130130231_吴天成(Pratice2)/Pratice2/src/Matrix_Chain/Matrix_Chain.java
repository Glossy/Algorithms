package Matrix_Chain;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Wu on 2017/4/16.
 */
public class Matrix_Chain{
    public Matrix_Chain(int[] s) {
        p = s;
        cost = new int[s.length - 1][s.length - 1];
        cutpoint = new int[s.length - 2][s.length - 2];
        this.Ordered();
    }
    private int cost[][];
    private int cutpoint[][];
    private int p[];

    public void Ordered(){
        int chainlength;
        int i, j, k, tempcost;
        for(i = 0; i < p.length - 2; i++){
            cost[i][i] = 0;
        }
        for(chainlength = 2; chainlength <= p.length - 1; chainlength++){                           //链长为chainlength
            for(i = 1; i + chainlength - 1 <  p.length ; i++){                                      //从第i个矩阵开始
                j = i + chainlength - 1;
                cost[i - 1][j - 1] = -1;
                for(k = i;k <= j - 1;k++){                                                          //k为切割点
                    tempcost = cost[i - 1][k - 1] + cost[k][j - 1] + p[i-1]*p[k]*p[j];
                    if (tempcost < cost[i - 1][j - 1] || cost[i - 1][j - 1] == -1){
                        cost[i - 1][j - 1] = tempcost;
                        cutpoint[i - 1][j - 2] = k;
                    }
                }
            }
        }
    }

    public void printCost(){
        System.out.println("Array Cost");
        for(int i = 0; i < cost.length; i++){
            for(int j = 0; j < cost[0].length; j++){
                System.out.print(String.format("%-6d   ",cost[i][j]));
            }
            System.out.print("\n");
        }
    }
    public void printCutpoint(){
        System.out.println("Array Cutpoint");
        for(int i = 0; i < cutpoint.length; i++){
            for(int j = 0; j < cutpoint[0].length; j++){
                System.out.print(String.format("%-6d   ",cutpoint[i][j]));
            }
            System.out.print("\n");
        }
    }

    public int[][] getCost(){return  cost;}
    public int[][]getCutpoint(){return cutpoint;}

}
