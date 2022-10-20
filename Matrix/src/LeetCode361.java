public class LeetCode361 {
    //361. Bomb Enemy
    final static int[] dirX={1,0,-1,0}; //direction arrays
    final static int[] dirY={0,1,0,-1};

    static int killMaxEnemies(char[][] grid){
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0)  return 0;

        int res=0;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if(grid[i][j]=='0'){
                    int currKillCount=helperDFS(grid,i,j);
                    res=Math.max(res,currKillCount);
                }
            }
        }
        return res;
    }

    static int helperDFS(char[][] grid,int x,int y){ //bomb the enemies using dfs
        int count=0;
        for (int i = 0; i < 4 ; i++) {
            int newX=x;
            int newY=y;
            while(isValid(grid,newX+dirX[i],newY+dirY[i])){
                newX+=dirX[i];
                newY+=dirY[i];
                if(grid[newX][newY]=='E')
                    count++;
            }
        }
        return count;
    }

    static boolean isValid(char[][] grid,int x,int y){
        return (x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]!='W');
    }

    public static void main(String[] args) {
        char[][] grid={{'0','E','0','0'},
                {'E','0','W','E'},
                {'0','E','0','0'}};

        System.out.println(killMaxEnemies(grid));

    }
}


//T.C - O(m*n) //m-->row length , n--> column length
//S.C - O(1) //constant fixed direction arrays so O(1)