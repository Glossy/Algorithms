package All_Pairs_Shortest_Path;

/**
 * Created by Wu on 2017/5/10.
 */
public class All_Pairs_Shortest_Path {
    int num;      //存节点个数
    int[][] edge; //保存每条边的代价
    int[][] Ans;

    public All_Pairs_Shortest_Path(){
        num = 5;
        edge = new int[num][num];

        for (int i=0; i<num; i++)
            for (int j=0; j<num; j++) {
                if (i == j)
                    edge[i][j] =0;
                else
                    edge[i][j] = Integer.MAX_VALUE;
            }
        edge[0][1] = 3;
        edge[0][2] = 8;
        edge[0][4] = -4;
        edge[1][3] = 1;
        edge[1][4] = 7;
        edge[2][1] = 4;
        edge[3][0 ] = 2;
        edge[3][2] = -5;
        edge[4][3] = 6;

        //ShowMatrix();
    }

    int[][] Extend_Shortest_path(int[][] L, int W[][]) {//L为上一次最短路径，W为代价
        int[][] Ans = new int[num][num];
        for (int from=0; from<num; from++) {
            for (int to=0; to<num; to++) {
                Ans[from][to] = Integer.MAX_VALUE;      //首先初始化
                for (int mid=0; mid<num; mid++) {//中间节点
                    if (W[mid][to] == Integer.MAX_VALUE || L[from][mid] == Integer.MAX_VALUE)
                        continue; //不可达
                    if (Ans[from][to] > L[from][mid] + W[mid][to]) {
                        Ans[from][to] = L[from][mid] + W[mid][to];
                    }
                }
            }
        }
        return Ans;
    }

    int[][] Slow_All_Pairs_Shortest_Path() {
        int[][] Pre = new int[num][num];
        for (int i=0; i<num; i++)
            for (int j=0; j<num; j++)
                Pre[i][j] = edge[i][j];


        for (int m=2; m<num; m++) {
            int[][] Ans;
            Ans = Extend_Shortest_path(Pre, edge);
            Pre = Ans;
            System.out.println("m = " + m);
            ShowMatrix(Pre);
        }
        this.Ans = Pre;
        return Pre;
    }

    void ShowMatrix(int[][] Matrix) {
        for (int i=0; i<num; i++) {
            for (int j=0; j<num; j++)
                System.out.printf("%4d",Matrix[i][j]);
            System.out.println();
        }
    }

    void ShowMatrix() {
        ShowMatrix(edge);
    }

    public static void main(String[] args) {
        All_Pairs_Shortest_Path apsp = new All_Pairs_Shortest_Path();
        apsp.Slow_All_Pairs_Shortest_Path();
    }
}

