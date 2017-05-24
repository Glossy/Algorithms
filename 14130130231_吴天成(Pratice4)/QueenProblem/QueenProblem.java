package QueenProblem;

/**
 * Created by Wu on 2017/5/10.
 * 如果某个位置可以放置
 * 1. 如果该行不是最后一行，则下一行为当前行，下一行第一列为当前列
 * 2. 如果该行是最后一行，则输出该矩阵，
 *      2.1 如果该列是最后一列，则回溯求其他解
 *      2.2 如果该列非最后一列，则移除当前棋子，取下一列为当前列
 * 如果某个位置不可放置
 * 1. 如果该列不是最后一列，则取下一列为当前列
 * 2. 如果当前列是最后一列，则回溯
 *
 *
 * 回溯函数
 * 清空该行所有元素
 * 1. 如果该行为第一行，则说明回溯到最起始情况，则推出
 * 2. 如果该行非最后一行，则取上一行为当前行。
 *      2.1 如果上一行的测试位置所在列是最后一列，则继续回溯上一行
 *      2.2 如果上一行的测试位置所在列非最后一列，则清除测试位置，并取下一列为测试位置
 */
public class QueenProblem {
    int num = 0;
    int[][] chessboard;
    int n;
    int PosX=0, PosY=0;

    public QueenProblem(int n) {
        this.n = n;
        chessboard = new int[n][n];
    }

    void run() {
        while (PosX<n) {    //如果所有行都检测过了，则退出
            if (canBePlaced(PosX, PosY)) {
                PlaceChess(PosX, PosY);
                if (PosX==n-1) {
                    Display();
                    if (PosY!=n-1) {
                        Remove(PosX, PosY);
                        PosY++;//这两步是一个动作，就是去下一个点，但是得把当前点设为0
                    }
                    else if (PosY==n-1) {
                        Remove(PosX, PosY);
                        Back();//与上一步同理，两步是一个东西
                    }
                }
                else if (PosX!=n-1) {
                    PosX++; PosY=0;
                }
            }
            else {
                if (PosY!=n-1) {
                    PosY++;
                } else if(PosY == n-1) {
                    Back();
                }
            }
        }
    }

    private void Back() {//回溯函数
        if (PosX == 0)  //如果回溯到第一行，说明全部结束，没有其他可能，故直接退出
            System.exit(-1);// return;

        PosX--;//设置上一行为当前行

        for (int Y=0; Y<n; Y++)
            if (chessboard[PosX][Y] == 1) {
                Remove(PosX, Y);//将该行之前的结果清除，
                if (Y != n-1) {//如果该列不是最后一列，则将该列的下一列设为当前测试点
                    PosY = Y+1;
                    break;
                }//如果当前行下一个待测位置是最后一列，则回溯上一行
                else {
                    Back();
                }
            }
    }

    private void Display() {
        num++;
        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                System.out.print(chessboard[x][y] + "   ");
            }
            System.out.println();
        }
        System.out.println(num);
    }

    private void PlaceChess(int PosX, int PosY) {   //放置棋子
        chessboard[PosX][PosY] = 1;
    }
    private void Remove(int PosX, int PosY) {       //移除棋子
        chessboard[PosX][PosY] = 0;
    }

    private boolean canBePlaced(int PosX, int PosY) {//判断是否可放置
        for (int i=0; i<n; i++) {
            if (i != PosX)
                if (chessboard[i][PosY] == 1)//检查列
                    return false;
            if (i != PosY)
                if (chessboard[PosX][i] == 1)//检查行
                    return false;
        }

        int i=PosX-1, j = PosY-1;
        while (i>=0 && j>=0) {              //检查坐上对角线
            if (chessboard[i][j] == 1)
                return false;
            i--; j--;
        }
        i=PosX+1; j = PosY+1;
        while (i<n && j<n) {                //检查右下对角线
            if (chessboard[i][j] == 1)
                return false;
            i++; j++;
        }

        i = PosX-1; j = PosY+1;
        while (i>=0 && j<n) {               //检查左下对角线
            if (chessboard[i][j] == 1)
                return false;
            i--; j++;
        }

        i = PosX+1; j = PosY-1;
        while (i<n && j>=0) {               //检查右下对角线
            if (chessboard[i][j] == 1)
                return false;
            i++; j--;
        }

        return true;
    }

    public static void main(String[] args) {
        QueenProblem queenProblem = new QueenProblem(8);
        queenProblem.run();
    }
}
