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
	
	public abstract String toString();
	public abstract ArrayList<String> legalMoves();	
	
	public Color getColor() {
		return color;
	}
	
	public String getPosition() {
		return getPositionString(column, row);	
	}
	
	public void setPosition(String position) throws IllegalPositionException {
		var posArray = position.toCharArray();
		if(position.length() == 2 && 
				posArray[0] >= 'a' && posArray[0] <= 'h' &&
				posArray[1] >= '1' && posArray[1] <= '8') {
			this.column = posArray[0] - 97;
			this.row = posArray[1] - 49;
		}
		else {
			throw new IllegalPositionException();
		}
	}
	
	protected String getPositionString(int col, int row) {
		if (col >= 0 && col <= 7 && row >= 0 && row <= 7) {
			var c = String.valueOf((char) (col + 97));
			var r = String.valueOf((char) (row + 49)); 
			return c + r;
		}
		
		return "";
	}
	
	protected boolean tryAddMove(int col, int row, ArrayList<String> legalMoves) {		
		try {
			var position = getPositionString(col, row);
			var piece = board.getPiece(position);
			
			if(piece == null || piece.getColor() != this.color) {
				legalMoves.add(position);
			}
			
			return piece == null;
		} 
		catch (IllegalPositionException e) {
			return false;
		}
	}
}
