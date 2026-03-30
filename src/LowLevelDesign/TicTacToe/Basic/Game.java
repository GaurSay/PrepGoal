package LowLevelDesign.TicTacToe.Basic;

import java.util.Scanner;

public class Game {

    Player p1, p2;

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
	
    private void play() {
        Scanner s = new Scanner(System.in);
		p1 = takeInput(1,s);
		p2 = takeInput(2,s);

		Board board = new Board(p1.getSymbol(), p2.getSymbol());
		boolean p1Turn = true;

		while (p1.getSymbol() == p2.getSymbol()) {
			System.out.println("Symbol already taken choose another please!!");
			char p2Symbol = s.nextLine().charAt(0);
			p2.setSymbol(p2Symbol);
		}
		// Game start
		int status = Board.Incomplete;
		while (status == Board.Invalid || status == Board.Incomplete) {
			System.out.println(p1Turn);
			if (p1Turn) {
				System.out.println("PLayer 1 -" + p1.getName() + "'s turn");
				System.out.println("Enter x :");
				int x = s.nextInt();
				System.out.println("Enter y :");
				int y = s.nextInt();
				status = board.move(p1.getSymbol(), x, y);
				System.out.println("Player 1 turn " + status);
				if (status != Board.Invalid) {
					p1Turn = false;
					board.print();
				} else {
					System.out.println("Invalid move try again!! ");
				}

			} else {
				System.out.println("PLayer 2 -" + p2.getName() + "'s turn");
				System.out.println("Enter x :");
				int x = s.nextInt();
				System.out.println("Enter y :");
				int y = s.nextInt();
				status = board.move(p2.getSymbol(), x, y);
				System.out.println("Player 2 turn " + status);
				if (status != Board.Invalid) {
					p1Turn = true;
					board.print();
				} else {
					System.out.println("Invalid move try again!! ");
				}
			}
		}
		if (status == Board.Player1_wins) {
			System.out.println("Player 1 winsss wohooo !!!!");
		} else if (status == Board.Player2_wins) {
			System.out.println("Player 2 winsss wohooo !!!!");
		} else {
			System.out.println("Its a drawww !!!!");
		}

    }

    private Player takeInput(int num,Scanner s) {
		System.out.println("Enter Player " + num + "'s name");
		String name = s.nextLine();
		System.out.println("Enter Player " + num + "'s symbol");
		char symbol = s.nextLine().charAt(0);
		Player p = new Player(name, symbol);
		return p;
	}


}
