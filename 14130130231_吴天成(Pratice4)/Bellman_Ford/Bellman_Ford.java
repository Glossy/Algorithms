package Bellman_Ford;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wu on 2017/5/10.
 */
public class Bellman_Ford {
    public static int max = Integer.MAX_VALUE;
    public int[][] map;
    public int pointNum;    //点的数量
    public int edgeNum;     //边的数量
    public boolean is;
    ArrayList<Node> nodes;

    public static void main(String args[]){
        int[][] m = {{max, 6, max, 7, max},
                {max, 0, 5, 8, -4},
                {max, -2, 0, max, max},
                {max, max, -3, 0, 9},
                {2, max, 7, max, 0}
        };
        Bellman_Ford b = new Bellman_Ford(m,5,10);
        String s = "Path: ";
        for(int i = 4; ;){
            if(b.nodes.get(i).preNode != null){
                s = s +" "+ b.nodes.get(i).nodeNum;
                i = b.nodes.get(i).preNode.nodeNum; //赋为上一个节点的值
            }else {
                s = s + " "+ b.nodes.get(i).nodeNum;
                break;
            }
        }
        System.out.println(s);
        System.out.println("Path Value: " + b.nodes.get(4).length);
    }


    public  Bellman_Ford(int[][] m, int point, int edge){
        map = m;
        pointNum = point;
        edgeNum = edge;
        nodes = new ArrayList<Node>(point);

        for(int i = 0; i < pointNum; i++){//初始化
            nodes.add(new Node(max, i));
        }
        nodes.get(0).length = 0;//源点

        for(int i = 1; i < point; i++){//距源点距离为1到n-1的节点
            for(int j = 0; j < point; j++) {//遍历所有边
                for (int k = 0; k < point; k++) {
                    if (map[j][k] != max) {
                        relaxation(nodes.get(j), nodes.get(k), map);
                    }
                }
            }
        }

        for(int i = 0; i < point; i++){
            for(int j = 0; j < point; j++){
                if(map[i][j] != max){
                    if(nodes.get(i).length > nodes.get(j).length + map[i][j]){//检查是否存在权值为负的环路
                        is =  false;
                        return;
                    }
                }
            }
        }
        is = true;
    }

    private void relaxation(Node u, Node v, int[][] nodeMap){//u为边前点，v为边后点
        if(v.length > u.length + nodeMap[u.nodeNum][v.nodeNum]){
            v.length = u.length + nodeMap[u.nodeNum][v.nodeNum];
            v.preNode = u;
        }
    }
}
