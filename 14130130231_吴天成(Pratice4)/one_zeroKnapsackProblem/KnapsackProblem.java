package one_zeroKnapsackProblem;

/**
 * Created by Wu on 2017/5/10.
 */
public class KnapsackProblem {
    private int total_weight;
    private double max_value;
    private int restWeight;
    private double currentValue;
    private item[] items;

    private double bound(int degree){
        double tempValue = currentValue;
        int tempWeight = restWeight;
        while (degree < items.length && restWeight >= items[degree].weight){    //若还可以装入则装到不能装入为止
            tempValue += items[degree].value;
            tempWeight -= items[degree].weight;
            degree ++;
        }
        if (degree < items.length){//若还没装到最后一个
            tempValue += tempWeight * items[degree].value / items[degree].weight;   //装入分数背包
        }
        return tempValue;
    }

    public void backTrace(int degree){
        if (degree >= items.length){    //当前查看的物品为最后一个
            max_value = currentValue;
            return;
        }
        if (restWeight >= items[degree].weight){    //当前查看的物品可以装入
            currentValue += items[degree].value;
            restWeight -= items[degree].weight;

            backTrace(degree + 1);      //查看下一个

            restWeight += items[degree].weight; //回溯上一个
            currentValue -= items[degree].value;
        }
        if (bound(degree + 1) > max_value){ //若不可装入,则检查bound函数所获得的最大值是否比现在大
            backTrace(degree + 1);  //再查看下一个
        }
    }

    public KnapsackProblem(int total_weight,item[] items){
        this.restWeight = 100;
        this.max_value = 0;
        this.currentValue = 0;
        this.total_weight = 100;
        this.items = items;
    }

    public static void main(String[] args) {
        item[] items = {
                new item('A', 50, 200),
                new item('B', 30, 180),
                new item('C', 45, 225),
                new item('D', 25, 200),
                new item('E', 5, 50)
        };
        KnapsackProblem pro = new KnapsackProblem(100,items);
        pro.backTrace(0);
        System.out.print(pro.max_value);

    }
}


class item{
    char name;
    double value;
    double weight;

    item(char name,double weight,double value){
        this.name = name;
        this.value = value;
        this.weight = weight;
    }
}
