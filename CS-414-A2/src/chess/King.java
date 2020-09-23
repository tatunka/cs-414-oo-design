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
		return new ArrayList<String>();
	}

}
