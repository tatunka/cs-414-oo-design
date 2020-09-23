package chess;
import java.util.ArrayList;

public abstract class ChessPiece {
	public enum Color {WHITE, BLACK}
	protected ChessBoard board;
	protected int row;
	protected int column;
	protected Color color;
	
	public ChessPiece(ChessBoard board, Color color) {
		this.board = board;
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getPosition() {
		throw new UnsupportedOperationException();
	}
	
	public void setPosition(String position) throws IllegalPositionException {
		
	}
	
	public abstract String toString();
	public abstract ArrayList<String> legalMoves();	
}
