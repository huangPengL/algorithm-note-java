package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/17 15:56
 **/
import java.io.*;

public class _04BigIntDiv {

    private static int r;

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        int b = Integer.parseInt(br.readLine());

        String c = div(a,b);

        // 输出
        for(int i=0;i<c.length();i++){
            System.out.print(c.charAt(i));
        }
        System.out.println("\n"+r);

        br.close();
    }

    // 大数a乘以小数b
    public static String div(String a,int b){
        r = 0;
        StringBuilder c = new StringBuilder();
        for(int i=0;i<a.length();i++){
            r = r*10 + (a.charAt(i)-'0');
            c.append(r / b);
            r = r % b;
        }

        // 去除前导0
        int index = 0;
        while(index<c.length() && c.charAt(index) == '0')   index++;
        if(index == c.length()) return "0";
        return c.substring(index);
    }
}