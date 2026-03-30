package LowLevelDesign.TicTacToe.Basic;

public class Board {

    //methods
    // move(char,x,y);
    // print()

    int n=3;
    private int count = 0;

	private char board[][];

	public final static int Player1_wins=1;
	public final static int Player2_wins=2;
	public final static int draw=3;
	public final static int Incomplete=4;
	public final static int Invalid=5;

	private char p1Symbol;
	private char p2Symbol;

    public Board(char symb1,char symb2) {
		this.p1Symbol = symb1;
		this.p2Symbol = symb2;

		board=new char[n][n];
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				board[i][j]=' ';
			}
		}
	}

	public int move(char symbol,int x,int y)
	{
		if(x>=n || x<0 || y>=n || y<0 || board[x][y]!=' ' )
		{
			return Invalid;
		}
		board[x][y]=symbol;
		count++;

		//check row
		if(board[x][0]==board[x][1] && board[x][0]==board[x][2])
		{
			return symbol==p1Symbol ? Player1_wins : Player2_wins;
		}

		//check column
		if(board[0][y]==board[1][y] && board[0][y]==board[2][y])
		{
			return symbol==p1Symbol ? Player1_wins : Player2_wins;
		}

		// check diagonal 1
		if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[0][0]==board[2][2])
		{
			return symbol==p1Symbol ? Player1_wins : Player2_wins;
		}

		// check diagonal 2
		if(board[2][0]!=' ' && board[0][2]==board[1][1] && board[0][2]==board[2][0])
		{
			return symbol==p1Symbol ? Player1_wins : Player2_wins;
		}

		if(count==n*n)
		{
			return draw;
		}
		return Incomplete;
	}

    public void print()
	{
		System.out.println("--------------------");
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(" | "+board[i][j]+" |");
			}
			System.out.println();
			System.out.println("--------------------");
		}
	}

}
