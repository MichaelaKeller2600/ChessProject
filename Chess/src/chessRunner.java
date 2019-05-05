import java.util.ArrayList;
import java.util.Scanner;

public class chessRunner {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Pieces.Type pieceType = null;
		Pieces.Color pieceColor = null;
		ArrayList<Pieces> fun = new ArrayList<Pieces>();
		
		fun.add(new King(4, 8, pieceColor.white));
		fun.add(new King(4, 1, pieceColor.black));
		
		fun.add(new Queen(5, 8, pieceColor.white));
		fun.add(new Queen(5, 1, pieceColor.black));
		
		fun.add(new Bishop(3, 8, pieceColor.white));
		fun.add(new Bishop(6, 8, pieceColor.white));
		fun.add(new Bishop(3, 1, pieceColor.black));
		fun.add(new Bishop(6, 1, pieceColor.black));
		
		fun.add(new Knight(2, 8, pieceColor.white));
		fun.add(new Knight(7, 8, pieceColor.white));
		fun.add(new Knight(2, 1, pieceColor.black));
		fun.add(new Knight(7, 1, pieceColor.black));
		
		fun.add(new Rook(1, 8, pieceColor.white));
		fun.add(new Rook(8, 8, pieceColor.white));
		fun.add(new Rook(1, 1, pieceColor.black));
		fun.add(new Rook(8, 1, pieceColor.black));
		
		fun.add(new Pawn(1, 7, pieceColor.white));
		fun.add(new Pawn(2, 7, pieceColor.white));
		fun.add(new Pawn(3, 7, pieceColor.white));
		fun.add(new Pawn(4, 7, pieceColor.white));
		fun.add(new Pawn(5, 7, pieceColor.white));
		fun.add(new Pawn(6, 7, pieceColor.white));
		fun.add(new Pawn(7, 7, pieceColor.white));
		fun.add(new Pawn(8, 7, pieceColor.white));
		
		fun.add(new Pawn(1, 2, pieceColor.black));
		fun.add(new Pawn(2, 2, pieceColor.black));
		fun.add(new Pawn(3, 2, pieceColor.black));
		fun.add(new Pawn(4, 2, pieceColor.black));
		fun.add(new Pawn(5, 2, pieceColor.black));
		fun.add(new Pawn(6, 2, pieceColor.black));
		fun.add(new Pawn(7, 2, pieceColor.black));
		fun.add(new Pawn(8, 2, pieceColor.black));
		fun.add(new Pawn(8, 3, pieceColor.black));
		
		Board game = new Board();
		game.basicSetup(fun);
		game.printBoard();
		
		for(int i = 1; i < 6; i++) {
			System.out.print(i + ": Which row is the pawn you would like to move in? Column? ");
			int y = in.nextInt() - 1;
			int x = in.nextInt() - 1;
		
			if(game.getGamePeice(x, y).canMove( x, y + 1, game))
				game.getGamePeice(x, y).moveMethod(x, y + 1, game, x, y);
		
			game.printBoard();
		}
	}

}
