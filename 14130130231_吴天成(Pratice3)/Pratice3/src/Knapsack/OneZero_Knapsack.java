package Knapsack;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Created by Wu on 2017/4/22.
 */
public class OneZero_Knapsack {
    public OneZero_Knapsack(int[][] item, int max){
        items = item;
        solution = new int[item.length];
        maxWeight = max;
        cost = new int[item.length + 1][maxWeight + 1];
        findSolution();
    }
    private int maxWeight;
    private int[][]  items;
    private int[] solution;
    private int[][] cost;
    private void findSolution(){
        int i, j;
        int k;
        for(i = 1; i <= items.length; i++){
            for(j = 0; j < maxWeight + 1; j = j + 5){
                if(items[i - 1][1] > j){
                    cost[i][j] = cost[i - 1][j];
                }
                else {
                        cost[i][j] = max(cost[i - 1][j - items[i - 1][1]] + items[i - 1][2],cost[i - 1][j]);

                }
            }
        }
        j = maxWeight;
        k = 0;
        for(i = items.length; i > 0; i--){
            if(cost[i][j] > cost[i - 1][j]){
                solution[k++] = i;
                j = j - items[i - 1][1];
            }
        }
    }

    public int[] getSolution(){return solution;}
    public void printSolution() {
        System.out.println("Item  Weights  Value");
        for (int i = 0; i < solution.length; i++) {
            if (solution[i] == 0) {
                break;
            }
            System.out.printf((char)items[solution[i] - 1][0] + "     %-2d       %d \n",  items[solution[i] - 1][1], items[solution[i] - 1][2]);
        }
        System.out.printf("Max value is %d \n",cost[items.length][maxWeight]);
    }
}
