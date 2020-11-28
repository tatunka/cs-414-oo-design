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
			
			if(checkTopRight) {
				checkTopRight = tryAddMove(column + x, row + x, legalMoves);
			}
			if(checkBottomRight) {
				checkBottomRight = tryAddMove(column - x, row + x, legalMoves);
			}
			if(checkBottomLeft) {
				checkBottomLeft = tryAddMove(column - x, row - x, legalMoves);
			}
			if(checkTopLeft) {
				checkTopLeft = tryAddMove(column + x, row - x, legalMoves);
			}
		}
		
		return legalMoves;
	}

}
