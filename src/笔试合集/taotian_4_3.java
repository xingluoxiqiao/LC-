package 笔试合集;

import java.util.*;

public class taotian_4_3 {
    //题目描述
    //K小姐有一个长度为n的数组a，她定义一个数组的权值为数组中不同数字的个数。
    //现在，K小姐想从数组α中选出k个数字，使得这k个数字组成的新数组的权值最大。你能帮助K小姐找出最大的权值吗?
    //输入格式
    //第一行包含两个正整数n和k (1<k <n ≤10^5)，表示数组α的长度和需要选择的数字个数。
    //第二行包含n个正整数a1 , a2 , . . . ,an(1 <a <10^9)，表示数组α的元素。
    //输出格式
    //输出一个正整数，表示选出k个数字组成新数组的最大权值。
    public static void main1(){
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
        int[] nums=new int[n];
        HashSet<Integer> hashSet=new HashSet<>();
        for(int i=0;i<n;i++){
            hashSet.add(scanner.nextInt());
        }
        System.out.println(Math.min(k,hashSet.size()));

    }

    //卢小姐计划去旅行，她要走遍n个城市。从一个城市到相邻的城市需要消耗1单位的体力。每个城市都有特色美食，每份售价为a;，卢小姐可以在每个城市购买任意份美食。
    //卢小姐想要用最少的花费走完全程，但是她希望每个城市的美食不要吃太多，即在一个城市重复进餐的次数的最大值最小。
    //卢小姐想知道一种满足上述条件的美食购买方案。如果有多种方案，输出任意一种即可。
    //输入格式
    //第—行输入—个整数n(1<n≤10^5) ，表示城市个数。
    //第二行输入n个整数，表示每个城市的美食售价ai(1 ≤ai ≤10^5)。
    //输出格式
    //输出—行整数，表示每个城市购买的美食份数。
    public static void main2(){
        //1.首要满足最小花费(价格低的优先级高)
        //2.次要满足不在一个城市吃太多（次数少的优先级高）
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        //反悔贪心？ 优先级队列
        //优先级队列中保存的数组，排序：当前城市的价格，当前城市吃的次数，当前是哪个城市，价格从小到大排，价格相同时优先次数少的
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y) -> x[0]!=y[0]?x[0]-y[0]:x[1]-y[1]);
        for(int j=0;j<n;j++){
            pq.offer(new int[]{nums[j],0,j});
        }
        int[] ans = new int[n];
        for(int i=0;i<n-1;i++){
            int[] top=pq.poll();
            ans[top[2]]++;
            pq.offer(new int[]{top[0],top[1]+1,top[2]});
        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }

    //问题描述
    //K小姐和A先生在玩一款名为元素调整的游戏。K小姐有一串宝石，每颗宝石都有一个能量值。为了保持宝石的和谐，K小姐希望通过调整能量值，
    //使得她的宝石串中的能量值不递减，并且每颗宝石的能量值必须与A先生提供的宝石能量值匹配。
    //K小姐可以通过施加魔法来增加或减少宝石的能量值（每次操作改变1单位能量)。她想知道，为了达到目标，最少需要施展多少次魔法。
    //输入格式
    //第一行包含两个正整数n, m，分别表示K小姐和A先生宝石串的长度。
    //第二行共n个空格分开的正整数a1 , a2 ,. . . , an，表示K小姐宝石串的初始能量值。
    //第三行共m个空格分开的正整数b1 , b2,.. . , bm，表示A先生宝石串的能量值。
    //输出格式
    //输出—个整数，表示K小姐达到目标所需的最少魔法施展次数。
    public static void main3(){
        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.nextLine().split(" ");
        int n=Integer.parseInt(first[0]),m=Integer.parseInt(first[1]);
        int[] K = new int[n],A=new int[m];
        for(int i=0;i<m;i++){
            K[i]=scanner.nextInt();
        }
        for(int i=0;i<m;i++){
            A[i]=scanner.nextInt();
        }
        Arrays.sort(A);

        //dp[i][j]是将第i颗宝石与第j颗宝石匹配的所有操作次数之和最小值
        int[][] dp=new int[n+1][m+1];
        for(int[] row :dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int j=0;j<m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<m;i++){
            int temp=dp[i-1][0];
            for(int j=1;j<m;j++){
                temp=Math.min(temp,dp[i-1][j]);
                int val=Math.abs(K[i-1]-A[j-1]);
                dp[i][j] = Math.min(dp[i - 1][j], temp) + val;
            }
        }
        int ans = Arrays.stream(dp[n]).min().orElse(Integer.MAX_VALUE);
        System.out.println(ans);

    }

    public static void main(String[] args) {
       // main1();
        main2();
    }





}
