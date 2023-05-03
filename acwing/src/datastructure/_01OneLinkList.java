package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/22 12:53
 */
import java.util.*;
import java.io.*;

public class _01OneLinkList {
    private static int head;        // 头节点指向的元素
    private static int[] e;         // e[i]表示节点i的值
    private static int[] ne;        // ne[i]表示节点i的下一个元素的下标
    private static int cur;         // 下一个待操作的下下标

    public static void main(String[] args) throws IOException{
        // 输入
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        init(n);

        // 操作
        while(n-- != 0){
            char operate = in.next().charAt(0);
            if(operate == 'H'){
                insertHead(in.nextInt());
            }
            else if(operate == 'D'){
                deletKthBack(in.nextInt());
            }
            else if(operate == 'I'){
                insertKthBack(in.nextInt(),in.nextInt());
            }
        }

        // 输出
        for(int i=head;i!=-1;i=ne[i]){
            System.out.print(e[i]+" ");
        }

    }
    // 初始化
    public static void init(int n){
        head = -1;
        e = new int[n];
        ne = new int[n];
        cur = 1;                // 第一个插入的位置为1，然后递增
    }

    // 向链表头插入一个数；
    public static void insertHead(int val){
        e[cur] = val;
        ne[cur] = head;
        head = cur;
        cur++;
    }

    //删除第 k 个插入的数后面的数；
    public static void deletKthBack(int k){
        if(k == 0)  head = ne[head];
        ne[k] = ne[ne[k]];
    }

    //在第 k 个插入的数后插入一个数。
    public static void insertKthBack(int k,int val){
        e[cur] = val;
        ne[cur] = ne[k];
        ne[k] = cur;
        cur++;
    }
}
