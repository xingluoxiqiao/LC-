package hot100;
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
//如果 word 存在于网格中，返回 true ；否则，返回 false 。
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，
//其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
public class Solution_79 {
    public boolean exist(char[][] board, String word) {
        int h=board.length,w=board[0].length;
        boolean[][] visited=new boolean[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                boolean flag=check(board,visited,i,j,word,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     *
     * @param board 需要遍历的图
     * @param visited 记录当前格点是否已经被使用过
     * @param i 横坐标
     * @param j 纵坐标
     * @param s 字符串
     * @param k 即将匹配到的字符索引(已经匹配成功的字符数)
     * @return 结果：当前节点是否可以继续匹配（当前节点只要有一个）
     */
    private boolean check(char[][] board,boolean[][] visited,int i,int j,String s,int k){
        //当前节点不等于当前需要匹配的字符，直接返回不可以继续匹配，转向其它方向
        if(board[i][j]!=s.charAt(k)){
            return false;
        }else if(k==s.length()-1){
            //所有字符全部匹配成功，逐层返回true
            return true;
        }
        visited[i][j]=true;
        int[][] direction={{0,1},{0,-1},{-1,0},{1,0}};
        boolean result=false;
        for(int[] dir:direction){
            int newi=i+dir[0];
            int newj=j+dir[1];
            if(newi>=0&&newi<board.length&&newj>=0&&newj<board[0].length){
                if(!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    //只要有一个相邻节点符合，则立即跳出循环返回true
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        //本层返回时，回溯（如果走错了，必须要回溯，如果走对了，回不回溯无所谓，所以可以放在这里）
        visited[i][j]=false;
        //如果四个方向都不能继续匹配，返回false，有一个方向可以继续匹配，则当前节点可以继续匹配，返回true
        return result;
    }
}
