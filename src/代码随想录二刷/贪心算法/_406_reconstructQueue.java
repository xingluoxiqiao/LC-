package 代码随想录二刷.贪心算法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

//根据身高重建队列
public class _406_reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        //本题有两个维度，务必一个一个来，否则容易顾此失彼
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //身高相同时，按k升序排序
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                //身高不同时，按身高从大到小排序，这样后续按k插入时可以直接插入对应索引
                return o2[0]-o1[0];
            }
        });
//        Arrays.sort(people, (a, b) -> {
//            if (a[0] == b[0]) return a[1] - b[1];   // a - b 是升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
//            return b[0] - a[0];   //b - a 是降序排列，在a[0] != b[0]，的狀況會根據h值降序排列
//        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1],p);   //Linkedlist.add(index, value)，会將value插入到指定index里。
        }
        return que.toArray(new int[people.length][]);
    }
}
