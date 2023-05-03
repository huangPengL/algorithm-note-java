package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/23 15:55
 */
import java.util.*;
import java.io.*;

public class _02TwoLinkList {
    private static int head;        // 头节点指向的元素
    private static int tail;        // 尾节点指向的元素
    private static int[] e;         // e[i]表示节点i的值
    private static int[] pe;        // pe[i]表示节点i的上一个元素的下标
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
            String operate = in.next();
            if(operate.equals("L")){
                insertLeft(in.nextInt());
            }
            else if(operate.equals("R")){
                insertRight(in.nextInt());
            }
            else if(operate.equals("D")){
                deletKth(in.nextInt());
            }
            else if(operate.equals("IL")){
                insertKthLeft(in.nextInt(),in.nextInt());
            }
            else if(operate.equals("IR")){
                insertKthRight(in.nextInt(),in.nextInt());
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
        tail = -1;
        e = new int[n];
        pe = new int[n];
        ne = new int[n];
        cur = 1;                // 第一个插入的位置为1，然后递增
    }

    // 表示在链表的最左端插入数 x；
    public static void insertLeft(int val){
        // 将新节点插入最左端
        e[cur] = val;
        pe[cur] = -1;
        ne[cur] = head;
        // 修改头节点
        head = cur;

        // 如果插入后节点数等于1，则设置tail指向这个元素
        if(tail == -1)  tail = cur;
            // 如果节点数大于1，则将新节点的下一个节点的前指向改变
        else    pe[ne[cur]] = cur;

        cur++;
    }

    // 表示在链表的最右端插入数 x；
    public static void insertRight(int val){
        // 将新节点插入最右端
        e[cur] = val;
        pe[cur] = tail;
        ne[cur] = -1;
        // 修改尾节点
        tail = cur;


        // 如果插入后节点数等于1，则设置head指向这个元素
        if(head == -1)  head = cur;
            // 如果节点数大于1，则将新节点的上一个节点的后指向改变
        else    ne[pe[cur]] = cur;

        cur++;
    }

    // 将第 k 个插入的数删除。
    public static void deletKth(int k){
        if(head == tail){
            head = -1;
            tail = -1;
        }
        else if(head == k){
            pe[ne[k]] = -1;
            head = ne[k];
        }
        else if(tail == k){
            ne[pe[k]] = -1;
            tail = pe[k];
        }
        else{
            pe[ne[k]] = pe[k];
            ne[pe[k]] = ne[k];
        }
    }

    // 在第 k 个插入的数左侧插入一个数。
    public static void insertKthLeft(int k,int val){
        if(head == k){
            insertLeft(val);
        }
        else{
            e[cur] = val;
            ne[cur] = k;
            pe[cur] = pe[k];
            pe[k] = cur;
            ne[pe[cur]] = cur;
            cur++;
        }
    }
    // 在第 k 个插入的数左侧插入一个数。
    public static void insertKthRight(int k,int val){
        if(tail == k){
            insertRight(val);
        }
        else{
            e[cur] = val;
            ne[cur] = ne[k];
            pe[cur] = k;
            ne[k] = cur;
            pe[ne[cur]] = cur;
            cur++;
        }
    }
}

