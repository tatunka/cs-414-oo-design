package chess;
import java.util.ArrayList;

public class Bishop extends ChessPiece {

	public Bishop(ChessBoard board, ChessPiece.Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return null;
	}

}
