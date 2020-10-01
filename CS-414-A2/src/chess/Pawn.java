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
			var piece1 = getColorByPosition(position1);
			if( piece1 == null) {
				legalMoves.add(position1);
			}
			
			if(row == 2 && piece1 == null) {
				var position2 = getPositionString(column, row + 2);
				var piece2 = getColorByPosition(position2);
				
				if(piece2 == null) {
					legalMoves.add(position2);
				}
			}
			
			var rightPosition = getPositionString(column + 1, row + 1);
			
			if(getColorByPosition(rightPosition) == Color.BLACK) {
				legalMoves.add(rightPosition);
			}
			
			var leftPosition = getPositionString(column - 1, row + 1);
			
			if(getColorByPosition(leftPosition) == Color.BLACK) {
				legalMoves.add(leftPosition);
			}
		}
		
		if(color == Color.BLACK) {
			if(row == 7) {
				var position1 = getPositionString(column, row - 1);
				var piece1 = getColorByPosition(position1);
				if( piece1 == null) {
					legalMoves.add(position1);
				}
				
				if(row == 2 && piece1 == null) {
					var position2 = getPositionString(column, row - 2);
					var piece2 = getColorByPosition(position2);
					
					if(piece2 == null) {
						legalMoves.add(position2);
					}
				}
			}
			
			var rightPosition = getPositionString(column + 1, row - 1);
			
			if(getColorByPosition(rightPosition) == Color.WHITE) {
				legalMoves.add(rightPosition);
			}
			
			var leftPosition = getPositionString(column - 1, row - 1);
			
			if(getColorByPosition(leftPosition) == Color.WHITE) {
				legalMoves.add(leftPosition);
			}
		}
		
		return legalMoves;
	}
}
