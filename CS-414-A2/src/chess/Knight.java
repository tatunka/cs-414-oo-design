package chess;
import java.util.ArrayList;

public class Knight extends ChessPiece {

	public Knight(ChessBoard board, ChessPiece.Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		switch (color) {
			case WHITE:
				return "\u2658";
			case BLACK:
				return "\u265E";
			default:
				return null;
		}
	}

	@Override
	public ArrayList<String> legalMoves() {
		return new ArrayList<>();
	}

}
