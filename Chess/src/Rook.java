public class Rook extends Pieces{
	public Rook(int a, int b, Color c) {
		setxPosition(a);
		setyPosition(b);
		setPieceColor(c);
		setPieceType(Pieces.Type.Rook);
	}
	public boolean canMove(int xMove, int yMove, Board gameBoard) {
		int xMoves = this.getxPosition() - 1 - xMove;	//Negative indicates left, positive indicates right
		int yMoves = this.getyPosition() - 1 - yMove;	//Negative indicates down, positive indicates up
		
		if(gameBoard.getGamePeice(xMove, yMove) == null || gameBoard.getGamePeice(xMove, yMove).isOpponent((Pieces)this)) {
			if (xMoves == 0 || yMoves > 0) {
				int counter = 0;
				for(int i = this.getyPosition() - 1; i <= 8; i++) {
		//			System.out.println(gameBoard.getGamePeice(xMove, i));
					if(gameBoard.getGamePeice(xMove, i) == null)
						counter++;
					else
						break;
				}
				System.out.println(counter + " " + yMoves);
				if(counter >= yMoves || (counter + 1 >= yMoves && gameBoard.getGamePeice(xMove, yMove).isOpponent((Pieces)this)))
					return true;
				else
					return false;
			}
			else if (xMoves == 0 || yMoves < 0) {
				int counter = 0;
				for(int i = this.getyPosition(); i >= 0; i--) {
					if(gameBoard.getGamePeice(xMove, i) == null)
						counter++;
					else
						break;
				}
				System.out.println("hit2");
				if(counter >= Math.abs(yMoves) || (counter + 1 >= Math.abs(yMoves) && gameBoard.getGamePeice(xMove, yMove).isOpponent((Pieces)this)))
					return true;
				else
					return false;
			}
		}
		System.out.println("You can't move that Rook, oof!");
		return false;
	}
	
	public void moveMethod(int xMove, int yMove, Board game, int origX, int origY) {
		game.setGamePiece(this, xMove + 1, yMove + 1);
		setxPosition(xMove + 1);
		setyPosition(yMove + 1);
		game.removeGamePiece(origX, origY);
	}
	
	public String toString() {
		if(this.getPieceColor() == Color.white)
			return "wRook";
		else
			return "bRook";
	}

}
