package chess;
import java.util.ArrayList;

public class Pawn extends ChessPiece {

	public Pawn(ChessBoard board, ChessPiece.Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		switch(color) {
			case WHITE:
				return "\u2659";
			case BLACK:
				return "\u265F";
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
