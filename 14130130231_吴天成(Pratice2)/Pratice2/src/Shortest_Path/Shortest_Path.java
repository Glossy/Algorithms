package Shortest_Path;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Wu on 2017/4/19.
 */
public class Shortest_Path {
    public Shortest_Path(int[][] m){
        map = m;
        node = new int [m.length][3];
        for(int i = 0; i < map.length; i++){
                node[i][0] = i;
                node[i][1] = Integer.MAX_VALUE;
        }
    }
    private int node[][];
    private int[][] map;
    private int[] path;
    public void findPath(){
        int temp;
        int length;
        node[0][1] = 0;
        for(int i = 0;i < map.length; i++){
            for(int j = 0;j < map.length; j++){
                if(map[i][j] != -1 && map[i][j] != 0){      //找到了相连节点
                    temp = node[i][1] + map[i][j];        //上一个节点的最短路径的值+与下一个节点相连路径上的值
                    if(temp < node[j][1]){              //判断是否比原先的值要小，如果小就将0-j节点的长度替换
                        node[j][1] = temp;
                        node[j][2] = i;            //记录前一个节点的序号
                    }
                }
            }
        }
        ArrayList<Integer> t = new ArrayList<Integer>();
        for(int i = node.length - 1; i >= 0; ){
            t.add(i);
            i = node[i][2];
            if(i == 0){
               t.add(i);
               break;
            }
        }
        path = new int[t.size()];
        Collections.reverse(t);
        Integer[] s = new Integer[t.size()];
        s = (Integer[])t.toArray(s);
        for(int i = 0; i < t.size(); i++){
            path[i] = s[i];
        }

    }

    public int[] getPath(){return path;}

    public void printPath(){
        System.out.print("Path is ");
        for(int i = 0; i < path.length; i++){
            System.out.print(path[i] + " ");
        }
        System.out.print("\n");
    }

    public int getPathvalue(){
        return node[node.length - 1][1];
    }
}
