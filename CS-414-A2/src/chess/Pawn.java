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
		var legalMoves = new ArrayList<String>();
		
		if(color == Color.WHITE) {
			var position1 = getPositionString(column, row + 1);
			try {
				var piece1 = board.getPiece(position1);
				if( piece1 == null) {
					legalMoves.add(position1);
				}
				
				if(row == 1 && piece1 == null) {
					var position2 = getPositionString(column, row + 2);
					var piece2 = board.getPiece(position2);
					
					if(piece2 == null) {
						legalMoves.add(position2);
					}
				}
				
			} catch (IllegalPositionException e) {
				e.printStackTrace();
			}
			
			
			try {
				var rightPosition = getPositionString(column + 1, row + 1);
				var rightPiece = board.getPiece(rightPosition);
				
				if(rightPiece != null && rightPiece.getColor() == Color.BLACK) {
					legalMoves.add(rightPosition);
				}
			}
			catch(IllegalPositionException e) {}
			
			try {
				var leftPosition = getPositionString(column - 1, row + 1);
				var leftPiece = board.getPiece(leftPosition);
				
				if(leftPiece != null && leftPiece.getColor() == Color.BLACK) {
					legalMoves.add(leftPosition);
				}
			}
			catch(IllegalPositionException e) {}
			
		}
		
		if(color == Color.BLACK) {
			var position1 = getPositionString(column, row - 1);
			try {
				var piece1 = board.getPiece(position1);
				if( piece1 == null) {
					legalMoves.add(position1);
				}
				
				if(row == 6 && piece1 == null) {
					var position2 = getPositionString(column, row - 2);
					var piece2 = board.getPiece(position2);
					
					if(piece2 == null) {
						legalMoves.add(position2);
					}
				}
			}
			catch (IllegalPositionException e) {}
			
			try {
				var rightPosition = getPositionString(column + 1, row - 1);
				var rightPiece = board.getPiece(rightPosition);
				
				if(rightPiece != null && rightPiece.getColor() == Color.WHITE) {
					legalMoves.add(rightPosition);
				}
			}
			catch(IllegalPositionException e) {}
			
			try {
				var leftPosition = getPositionString(column - 1, row - 1);
				var leftPiece = board.getPiece(leftPosition);
				
				if(leftPiece != null && leftPiece.getColor() == Color.WHITE) {
					legalMoves.add(leftPosition);
				}
			}
			catch(IllegalPositionException e) {}
		}
		
		return legalMoves;
	}
}
