import Bin_Packing.Bin_Packing;
import Knapsack.Fraction_Knapsack;
import Knapsack.OneZero_Knapsack;
import Thread_Scheduling.Thread_Scheduling;

/**
 * Created by Wu on 2017/4/22.
 */
public class main {
    public static void main(String args[]){
        /**关于01背包问题代码，使用OneZero_Knapsack类*/
//        int[][] items = {{'A',50,200},
//                {'B',30,180},
//                {'C',45,225},
//                {'D',25,200},
//                {'E',5,50}};
//        OneZero_Knapsack d = new OneZero_Knapsack(items, 100);
//        d.printSolution();


        /**关于分数背包问题代码，使用Fraction_Knapsack类*/
//        int[][] items = {{'A',50,200},
//                {'B',30,180},
//                {'C',45,225},
//                {'D',25,200},
//                {'E',5,50}};
//        Fraction_Knapsack s = new Fraction_Knapsack(items, 100);
//        s.printSolution();


        /**关于最小平均轮转时间问题代码，使用Thread_Schedling类*/
//        int[] runningtime = {15, 8, 3, 10};
//        Thread_Scheduling s = new Thread_Scheduling(runningtime);
//        s.printScheduling();


        /**关于装箱问题代码，使用Bin_Packing类*/
//        double[] bin = { 0.5,0.7,0.3,0.9,0.6,0.8,0.1,0.4,0.2,0.5};
//        Bin_Packing b = new Bin_Packing(bin, 1);
//        b.printInfo();


    }
}
