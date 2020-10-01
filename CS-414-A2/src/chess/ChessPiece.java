package chess;
import java.util.ArrayList;
import java.util.Collections;

public abstract class ChessPiece {
	public enum Color {WHITE, BLACK}
	protected ChessBoard board;
	protected int row;
	protected int column;
	protected Color color;
	protected ArrayList<Character> colLetters;
	
	public ChessPiece(ChessBoard board, Color color) {
		this.board = board;
		this.color = color;
		this.colLetters = new ArrayList<>();
		Collections.addAll(this.colLetters, 'a','b','c','d','e','f','g','h');
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
				posArray[1] >= '0' && posArray[1] <= '7') {
			this.column = colLetters.indexOf(posArray[0]);
			this.row = Integer.valueOf(posArray[1]) - 1;
		}
		else {
			throw new IllegalPositionException();
		}
	}
	
	protected String getPositionString(int col, int row) {
		if (col >= 0 && col <= 7 && row >= 0 && row <= 7) {
			return String.valueOf(colLetters.get(row)) + String.valueOf(row + 1);
		}
		
		return "";
	}
	
	protected Boolean isLegalMove(String move) {
		try {
			if(!move.isEmpty()) {
				var piece = board.getPiece(move);
				return piece.getColor() == this.color ? true : false;
			}
			
			return false;
		} 
		catch (IllegalPositionException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	protected Color getColorByPosition(String position) {
		try {
			var piece = board.getPiece(position);
			return piece.getColor();
		}
		catch(IllegalPositionException e) {
			return null;
		}
	}
}
