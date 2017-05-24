package Bin_Packing;
import java.util.ArrayList;

/**
 * Created by Wu on 2017/4/23.
 */
public class Bin_Packing {
    public Bin_Packing(double[] item, double binva){
        items = new ArrayList<Double>();
        binvalue = binva;
        for(int i = 0; i < item.length; i++){
            items.add(item[i]);
        }
        binNum = 0;
        bin= new double[item.length][item.length];
        findBinNum();
    }
    private double binvalue;
    private ArrayList<Double> items;
    private int binNum;
    private double[][] bin;

    public void findBinNum(){
        int i;
        double value;
        binNum = 1;
        value = binvalue;
        int k = 0;
        int length = bin.length;
        while (true) {
            for (i = items.size() - length; i < items.size(); i++) {
                if (items.get(i) <= value) {
                    bin[binNum - 1][k++] = items.get(i);
                    value = value - items.get(i);
                    items.remove(i);
                    length--;
                } else {
                    continue;
                }
            }
            if (length == 0) {
                break;
            } else {
                binNum++;
                k = 0;
                value = binvalue;
            }
        }
    }

    public int getBinNum(){return binNum;}

    public void printInfo(){
        for(int i = 0; i < bin.length && bin[i][0] != 0; i++){
            System.out.printf("Bin %d  ",i+1);
            for(int j = 0; j < bin[0].length; j++){
                if(bin[i][j] != 0){
                    System.out.printf("%4f  ",bin[i][j]);
                }
                else {
                    System.out.print("\n");
                    break;
                }
            }

        }
        System.out.println("Bin num is " + getBinNum());
    }
}
