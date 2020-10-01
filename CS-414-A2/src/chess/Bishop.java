package chess;
import java.util.ArrayList;

public class Bishop extends ChessPiece {

	public Bishop(ChessBoard board, ChessPiece.Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		switch (color) {
			case WHITE:
				return "\u2657";
			case BLACK:
				return "\u265D";
			default:
				return null;
		}
	}

	@Override
	public ArrayList<String> legalMoves() {
		var legalMoves = new ArrayList<String>();
		boolean checkTopRight = true, checkBottomRight = true, checkBottomLeft = true, checkTopLeft = true;
		
		for(var x = 1; x < 8; x++) {
			var topRight = getPositionString(column + x, row + x);
			var bottomRight = getPositionString(column - x, row + x);
			var bottomLeft = getPositionString(column - x, row - x);
			var topLeft = getPositionString(column + x, row - x);
			
			if(checkTopRight && isLegalMove(topRight)) {
				legalMoves.add(topRight);
			}
			else {
				checkTopRight = false;
			}
			
			if(checkBottomRight && isLegalMove(bottomRight)) {
				legalMoves.add(bottomRight);
			}
			else {
				checkBottomRight = false;
			}
			
			if(checkBottomLeft && isLegalMove(bottomLeft)) {
				legalMoves.add(bottomLeft);
			}
			else {
				checkBottomLeft = false;
			}
			
			if(checkTopLeft && isLegalMove(topLeft)) {
				legalMoves.add(topLeft);
			}
			else {
				checkTopLeft = false;
			}
		}
		
		return legalMoves;
	}

}
