package chess;
import java.util.ArrayList;

public class Queen extends ChessPiece {

	public Queen(ChessBoard board, ChessPiece.Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		switch(color) {
		case WHITE:
			return "\u2655";
		case BLACK:
			return "\u265B";
		default:
			return null;
		}
	}

	@Override
	public ArrayList<String> legalMoves() {
		return new ArrayList<String>();
	}

}
