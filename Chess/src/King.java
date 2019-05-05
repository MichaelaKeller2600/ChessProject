public class King extends Pieces{
	public King(int a, int b, Color c) {
		setxPosition(a);
		setyPosition(b);
		setPieceColor(c);
		setPieceType(Pieces.Type.King);
	}
	public boolean canMove(int xMove, int yMove, Board gameBoard) {
		System.out.println("hit");
		boolean direction = false, canTake = false;
		int xMoves = this.getxPosition() - xMove;	//Negative indicates left, positive indicates right
		int yMoves = this.getyPosition() - yMove;	//Negative indicates down, positive indicates up
		
		if (xMoves <= 1 && yMoves <= 1)
			direction = true;
		if (gameBoard.getGamePeice(xMove, yMove).isOpponent((Pieces)this))
			canTake = true;
		
		if(direction == true && canTake == true)
			return true;
		return false;
		
	}
	
	public void moveMethod(int xMove, int yMove, Board game, int origX, int origY) {
		game.setGamePiece(this, xMove + 1, yMove + 1);
		setxPosition(xMove);
		setyPosition(yMove);
		game.removeGamePiece(origX, origY);
	}
	
	public String toString() {
		if(this.getPieceColor() == Color.white)
			return "wKing";
		else
			return "bKing";
	}

}
