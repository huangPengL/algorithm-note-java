package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/6/14 15:32
 */
public class ComputeVarianceAndAvg {

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- != 0){
            double num = sc.nextDouble();
            list.add(num);
        }

        System.out.println("Avg: " + getAvg(list));
        System.out.println("Variance：" + getVariance(list));
    }

    public static double getVariance(List<Double> list){
        int n = list.size();
        double avg = getAvg(list);
        double sum = 0;
        for(Double item: list){
            sum += Math.pow(Math.abs(item-avg),2);
        }

        return sum/n;
    }

    public static double getAvg(List<Double> list){
        int n = list.size();
        double sum = 0;
        for(Double item: list){
            sum += item;
        }
        return sum/n;
    }
}
