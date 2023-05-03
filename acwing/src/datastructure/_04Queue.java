package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/23 16:47
 */
import java.util.*;
import java.io.*;

/*
push x – 向队尾插入一个数 x；
pop – 从队头弹出一个数；
empty – 判断队列是否为空；
query – 查询队头元素。
*/
public class _04Queue {
    private static int[] queue;
    private static int hh;
    private static int tt;

    public static void main(String[] args) throws IOException{
        // 输入
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        init(100000 + 10);
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
        queue = new int[n];
        hh = 0;
        tt = -1;
    }

    public static void push(int val){
        queue[++tt] = val;
    }
    public static void pop(){
        hh++;
    }
    public static void empty(){
        if(hh > tt){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    public static void query(){
        System.out.println(queue[hh]);
    }

}
