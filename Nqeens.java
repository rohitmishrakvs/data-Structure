import java.util.*; 

class Nqeens{
    static boolean isSafe( int [][]board ,int i , int j ,int n){
        for(int row = 0 ; row < i ; row++){
            if(board[row][j]==1){
                return false;
                }
        }
        int x=i;
        int y=j;
        while(x>=0 && y>=0){
            if(board[x][y]==1){
                return false;
            }
            x--;
            y--;
        }
        x=i;
        y=j;
        while(x>=0 && y<n){
            if(board[x][y]==1){
                return false;
            }
            x--;
            y++;
        }
        return true;
    }
    static boolean solveNqueen(int [][]board ,int i ,int n){
        if(i>=n){
            System.out.println("YES");
            for(int l = 0; l<n;l++){
                for(int j = 0 ;j<n;j++){
					System.out.print(board[l][j]+" ");
                }
                System.out.println("");
            }
            return true;
        }
        for(int j=0;j < n;j++){
            if(isSafe(board,i,j,n)){
                board[i][j]=1;
                boolean nextQueen = solveNqueen(board,i+1,n);
                if(nextQueen){
                    return true;
                }
				else{
                board[i][j]=0;
				}
			}
        }
        return false;
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]board=new int[n][n];
		
        if(solveNqueen(board,0,n)==false){
			System.out.println("No");
		}
    }
}

