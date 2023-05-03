package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/30 16:47
 */
/*
    我们可以用维护一个数组，ph[k]表示第k个插入的点在堆中的下标是多少。
    1 假设我们要删除第k个插入的点，那么就可以根据ph[k]来定位到堆中的下标，然后跟最后一个元素交换位置，再修堆
    2 有一个问题：假设堆中最后一个元素是第j个插入的点，我们可以通过ph[j]来定位到这个点。
        但是，我们又如何知道最后一个元素是第j个插入的点呢？因此，还需要一个额外的数组，hp[index]表示堆中下标为index的点是第
        几个插入的点。
*/

import java.io.*;

public class _10Heap {

    static int[] arr;
    static int[] ph;        // ph[k]表示第k个插入的点在堆中的下标是多少
    static int[] hp;        // hp[index]表示堆中下标为index的点是第几个插入的点
    static int size;        // 堆中的元素大小
    static int idx;         // 当前已经插入idx个数字

    // 初始化
    public static void init(int n){
        arr = new int[n+1];
        ph = new int[n+1];
        hp = new int[n+1];
        idx = 0;
        size = 0;
    }

    // 堆中特定的交换元素操作
    public static void heap_swap(int i,int j){
        swap(ph,hp[i],hp[j]);
        swap(hp,i,j);
        swap(arr,i,j);
    }

    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 向下修堆操作
    public static void heap_down(int curIndex){
        int index = curIndex;
        int leftIndex = curIndex<<1;
        int rightIndex = (curIndex<<1)+1;
        if(leftIndex <= size && arr[leftIndex] < arr[index]){
            index = leftIndex;
        }
        if(rightIndex <= size && arr[rightIndex] < arr[index]){
            index = rightIndex;
        }

        if(index != curIndex){
            heap_swap(index,curIndex);
            heap_down(index);
        }
    }

    // 向上修堆操作
    public static void heap_up(int curIndex){
        int parentIndex = curIndex>>1;
        while(parentIndex>=1 && arr[curIndex] < arr[parentIndex]){
            heap_swap(curIndex,parentIndex);
            curIndex = parentIndex;
            parentIndex = curIndex>>1;
        }
    }

    // - [1] 插入一个数字x
    public static void heap_insert(int x){
        ++size;
        ++idx;
        arr[size] = x;
        ph[idx] = size;
        hp[size] = idx;
        heap_up(size);
    }
    // - [2] 输出当前集合中的最小值:
    public static int heap_getMin(){
        return arr[1];
    }
    // - [3] 删除当前集合中的最小值（数据保证此时的最小值唯一）
    public static void heap_delMin(){
        heap_swap(1,size);
        size--;
        heap_down(1);
    }

    // - [4] 删除第k个插入的点：
    public static void heap_delKth(int k){
        int kIndex = ph[k];
        heap_swap(kIndex,size);
        size--;
        heap_down(kIndex);
        heap_up(kIndex);
    }

    // - [5] 修改第 k 个插入的数，将其变为 x
    public static void heap_modifyKth(int k,int x){
        int kIndex = ph[k];
        arr[kIndex] = x;
        heap_down(kIndex);
        heap_up(kIndex);
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        init(n);

        //
        StringBuilder ans = new StringBuilder();
        while(n-- != 0){
            String[] ss = br.readLine().split(" ");
            if(ss[0].equals("I")){
                int x = Integer.parseInt(ss[1]);
                heap_insert(x);
            }
            else if(ss[0].equals("PM")){
                ans.append(heap_getMin()).append("\n");
            }
            else if(ss[0].equals("DM")){
                heap_delMin();
            }
            else if(ss[0].equals("D")){
                int k = Integer.parseInt(ss[1]);
                heap_delKth(k);
            }
            else if(ss[0].equals("C")){
                int k = Integer.parseInt(ss[1]);
                int x = Integer.parseInt(ss[2]);
                heap_modifyKth(k,x);
            }
        }

        ans.deleteCharAt(ans.length()-1);
        System.out.println(ans.toString());
    }
}