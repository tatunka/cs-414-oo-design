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
		// TODO Auto-generated method stub
		return null;
	}

}
