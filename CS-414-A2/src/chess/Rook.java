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
			var top = getPositionString(column, row + x);
			var right = getPositionString(column + x, row);
			var left = getPositionString(column - x, row);
			var bottom = getPositionString(column, row - x);
			
			if(checkTop && isLegalMove(top)) {
				legalMoves.add(top);
			}
			else {
				checkTop = false;
			}
			
			if(checkRight && isLegalMove(right)) {
				legalMoves.add(right);
			}
			else {
				checkRight = false;
			}
			
			if(checkLeft && isLegalMove(left)) {
				legalMoves.add(left);
			}
			else {
				checkLeft = false;
			}
			
			if(checkBottom && isLegalMove(bottom)) {
				legalMoves.add(bottom);
			}
			else {
				checkBottom = false;
			}
		}
		return legalMoves;
	}

}
