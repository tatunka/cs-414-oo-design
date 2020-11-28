package chess;
import java.util.ArrayList;

public class Rook extends ChessPiece {

	public Rook(ChessBoard board, ChessPiece.Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		switch(color) {
			case WHITE:
				return "\u2656";
			case BLACK:
				return "\u265C";
			default:
				return null;
		}
	}

	@Override
	public ArrayList<String> legalMoves() {
		var legalMoves = new ArrayList<String>();
		boolean checkTop = true, checkRight = true, checkLeft = true, checkBottom = true;

		for(var x = 1; x < 8; x++) {
			
			if(checkTop) {
				checkTop = tryAddMove(column, row + x, legalMoves);
			}
			if(checkRight) {
				checkRight = tryAddMove(column + x, row, legalMoves);
			}
			if(checkLeft) {
				checkLeft = tryAddMove(column - x, row, legalMoves);
			}
			if(checkBottom) {
				checkBottom = tryAddMove(column, row - x, legalMoves);
			}
			
		}
		return legalMoves;
	}

}
