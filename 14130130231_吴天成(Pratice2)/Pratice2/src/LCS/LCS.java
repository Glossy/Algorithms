package LCS;

/**
 * Created by Wu on 2017/4/19.
 */
public class LCS {
    public LCS(String s1, String s2){
        a = s1;
        b = s2;
        length = new int[s1.length() + 1][s2.length() + 1];
        t = new int[s1.length()][s2.length()];
        LCS = "";
    }

    private String a, b;
    private String LCS;
    private int[][] length;
    private int[][] t;
    public void findLength(){
        int i , j;
        for(i = 1; i <= a.length(); i++){
            for(j = 1; j <= b.length(); j++){
                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    length[i][j] = length[i - 1][j - 1] + 1;
                    t[i - 1][j - 1] = -1;                   //-1表示a[i] = b[j]
                }
                else if(length[i][j - 1] >= length[i - 1][j]){
                    length[i][j] = length[i][j -1];
                    t[i - 1][j - 1] = 2;                    //2表示a[i] ！= b[j] && length[i][j - 1] >= length[i - 1][j]表示 a[1 - i-1]与b[1 - i]的最长公共子序列小于a[1 - i]与b[1 - i-1]
                }
                else{
                    length[i][j] = length[i - 1][j];
                    t[i -1][j - 1] = 1;                     //1表示a[i] ！= b[j] && length[i][j - 1] < length[i - 1][j]表示 a[1 - i-1]与b[1 - i]的最长公共子序列大于a[1 - i]与b[1 - i-1]
                }
            }
        }
        findLCS(a.length() - 1,b.length() - 1);
    }

    public void findLCS(int i,int j){
        if(i == -1 || j == -1){
            return;
        }
        if(t[i][j] == -1){
            findLCS(i-1,j-1);
            LCS = LCS + a.charAt(i);
        }
        else if(t[i][j] == 1){
            findLCS(i - 1,j);
        }
        else {
            findLCS(i,j - 1);}
    }

    public String getLCS(){return LCS;}
    public int[][] getLength(){return length;}
    public int[][] getT(){return t;}

    public void printLCS(){System.out.println(LCS);}
    public void printLength(){
        System.out.println("Array Length");
        for(int i = 0; i < length.length; i++){
            for(int j = 0; j < length[0].length; j++){
                System.out.print(String.format("%-6d   ",length[i][j]));
            }
            System.out.print("\n");
        }
    }
    public void printT(){
        System.out.println("Array T");
        for(int i = 0; i < t.length; i++){
            for(int j = 0; j < t[0].length; j++){
                if(t[i][j] == -1){
                    System.out.print("↖   ");
                }
                else if(t[i][j] == 1){
                    System.out.print("↑   ");
                }
                else {
                    System.out.print("←   ");
                }
            }
            System.out.print("\n");
        }
    }
}
