package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/23 16:13
 */

/*

push x – 向栈顶插入一个数 x；
pop – 从栈顶弹出一个数；
empty – 判断栈是否为空；
query – 查询栈顶元素。
*/

import java.util.*;
import java.io.*;

public class _03Stack {
    private static int[] stk;
    private static int tt;

    public static void main(String[] args) throws IOException{
        // 输入
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        init(100000+10);

        while(n-- != 0){
            String operate = in.next();
            if(operate.equals("push")){
                push(in.nextInt());
            }
            else if(operate.equals("pop")){
                pop();
            }
            else if(operate.equals("empty")){
                empty();
            }
            else if(operate.equals("query")){
                query();
            }
        }
    }

    public static void init(int n){
        stk = new int[n];
        tt = -1;
    }

    public static void push(int val){
        stk[++tt] = val;
    }
    public static void pop(){
        tt--;
    }
    public static void query(){
        System.out.println(stk[tt]);
    }
    public static void empty(){
        if(tt == -1)    System.out.println("YES");
        else System.out.println("NO");
    }
}