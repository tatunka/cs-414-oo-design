package chess;
import java.util.ArrayList;

public class King extends ChessPiece {

	public King(ChessBoard board, ChessPiece.Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		switch(color) {
			case WHITE:
				return "\u2654";
			case BLACK:
				return "\u265A";
			default:
				return null;
		}
	}

	@Override
	public ArrayList<String> legalMoves() {
		var possibleMoves = new ArrayList<String>();
		possibleMoves.add(getPositionString(column - 1, row));
		possibleMoves.add(getPositionString(column + 1, row - 1));
		possibleMoves.add(getPositionString(column + 1, row));
		possibleMoves.add(getPositionString(column + 1, row + 1));
		possibleMoves.add(getPositionString(column, row + 1));
		possibleMoves.add(getPositionString(column + 1, row - 1));
		possibleMoves.add(getPositionString(column, row - 1));
		possibleMoves.add(getPositionString(column - 1, row - 1));
		
		var legalMoves = new ArrayList<String>();
		
		for(var move : possibleMoves){
			if(isLegalMove(move)) {
				legalMoves.add(move);
			}
		}
		
		return legalMoves;
	}

}
