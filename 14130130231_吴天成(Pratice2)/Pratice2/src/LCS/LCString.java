package LCS;

/**
 * Created by Wu on 2017/4/19.
 */
public class LCString {

    private int[] max;// 保存最长子串长度的数组
    private int[] maxIndex;// 保存最长子串长度最大索引的数组
    private int[] c;
    private int len1, len2;
    private int maxLen;
    private char[] str1;
    private char[] str2;

    public LCString(char[] a, char[] b){
        str1 = a;
        str2 = b;
        len1 = str1.length;
        len2 = str2.length;
        maxLen = len1 > len2 ? len1 : len2;
        max = new int[maxLen];
        maxIndex = new int[maxLen];
        c = new int[maxLen];
    }

    public void getLCString() {
        int i, j;
        for (i = 0; i < len2; i++) {
            for (j = len1 - 1; j >= 0; j--) {   //从len-1 to 1 是因为如果正序循环的话，每次循环到值相等某结点时会把前一个可能不为0的c[]值覆盖为0
                if (str1[i] == str2[j]) {
                    if ((i == 0) || (j == 0))
                        c[j] = 1;
                    else
                        c[j] = c[j - 1] + 1;//此时C[j-1]还是上次循环中的值，因为还没被重新赋值
                } else {
                    c[j] = 0;
                }
                if (c[j] > max[0]) {        // 如果是大于那暂时只有一个是最长的,而且要把后面的清0;
                    max[0] = c[j];
                    maxIndex[0] = j;
                    for (int k = 1; k < maxLen; k++) {
                        max[k] = 0;
                        maxIndex[k] = 0;
                    }
                }
                else if (c[j] == max[0]) {  // 有多个是相同长度的子串
                    for (int k = 1; k < maxLen; k++) {
                        if (max[k] == 0) {
                            max[k] = c[j];
                            maxIndex[k] = j;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void printLCString(){
        for (int j = 0; j < maxLen; j++) {
            if (max[j] > 0) {
                System.out.println("第" + (j + 1) + "个公共子串:");
                for (int i = maxIndex[j] - max[j] + 1; i <= maxIndex[j]; i++)
                    System.out.print(str1[i]);
                System.out.println(" ");
            }
        }
    }

}
