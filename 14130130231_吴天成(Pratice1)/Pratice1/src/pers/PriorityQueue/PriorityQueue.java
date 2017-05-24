package pers.PriorityQueue;

import java.util.ArrayList;

/**
 * Created by Wu on 2017/3/29.
 */
public class PriorityQueue {                    //大顶堆
    public PriorityQueue(ArrayList<Integer> arry){
        for(int i = 0; i < arry.size();i++){
            Que.add(arry.get(i));
        }
        QueSize = arry.size();
        for(int i = QueSize/2 ;i >= 1;i--){
            MaxHeapify(i);
        }
    }
    private int QueSize;
    private ArrayList<Integer> Que = new ArrayList();
    private void MaxHeapify(int i){
        int left = 2 * i, right = 2 * i + 1;
        int largest;
        if(left < Que.size() && Que.get(i - 1) < Que.get(left - 1)){
            largest = left;
        }
        else{ largest = i;}
        if(right < Que.size() && Que.get(right - 1) > Que.get(largest - 1)){
            largest = right;
        }
        if(largest != i){
            int temp = Que.get(i - 1);
            Que.set(i - 1,Que.get(largest - 1));
            Que.set(largest - 1,temp);
            MaxHeapify(largest);
        }
    }
     public int Maxium(){
        return Que.get(0);
    }
    public int Extract_Max(){
         int top = Que.get(0);
         Que.remove(0);
         QueSize--;
         for(int i = QueSize/2;i >= 1; i--){
             MaxHeapify(i);
         }
         return top;
    }
    public void Increase_Key(int index,int value){
        Que.set(index,value);
    }
    public void Insert(int value){
        Que.add(value);
        QueSize++;
        for(int i = QueSize/2;i >= 1;i--){
            MaxHeapify(i);
        }
    }
}
