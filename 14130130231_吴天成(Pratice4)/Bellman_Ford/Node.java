package Bellman_Ford;

/**
 * Created by Wu on 2017/5/10.
 */
public class Node {
    public int length;
    public Node preNode;
    public int nodeNum;
    public Node(int length, int nodeNum){
        this.length = length;
        this.nodeNum = nodeNum;
        this.preNode = null;
    }
}
