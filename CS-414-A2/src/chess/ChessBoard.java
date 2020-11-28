package chess;

import chess.ChessPiece.Color;

public class ChessBoard {
	private ChessPiece[][] board;
	
	public ChessBoard() {
		board = new ChessPiece[8][8];
	}
	
	public void initialize() {
		placePiece(new Rook(this, Color.WHITE), "a1");
		placePiece(new Knight(this, Color.WHITE), "b1");
		placePiece(new Bishop(this, Color.WHITE), "c1");
		placePiece(new Queen(this, Color.WHITE), "d1");
		placePiece(new King(this, Color.WHITE), "e1");
		placePiece(new Bishop(this, Color.WHITE), "f1");
		placePiece(new Knight(this, Color.WHITE), "g1");
		placePiece(new Rook(this, Color.WHITE), "h1");
		
		for(int x = 97; x <= 104; x++) {
			placePiece(new Pawn(this, Color.WHITE), (char)x + "2");
		}
		
		placePiece(new Rook(this, Color.BLACK), "a8");
		placePiece(new Knight(this, Color.BLACK), "b8");
		placePiece(new Bishop(this, Color.BLACK), "c8");
		placePiece(new Queen(this, Color.BLACK), "d8");
		placePiece(new King(this, Color.BLACK), "e8");
		placePiece(new Bishop(this, Color.BLACK), "f8");
		placePiece(new Knight(this, Color.BLACK), "g8");
		placePiece(new Rook(this, Color.BLACK), "h8");
		
		for(int x = 97; x <= 104; x++) {
			placePiece(new Pawn(this, Color.BLACK), (char)x + "7");
		}
		
	}
	
	public ChessPiece getPiece(String position) throws IllegalPositionException {
		var p = position.toCharArray();
		if(p.length == 2 && p[0] >= 97 && p[0] <= 104 && p[1] >= 49 && p[1] <= 56) {
			return board[p[1] - 49][p[0] - 97];
		}
		
		throw new IllegalPositionException();
	}
	
	public boolean placePiece(ChessPiece piece, String position) {
		try {
			var pieceAtPosition = getPiece(position);
			if(pieceAtPosition == null || pieceAtPosition.color != piece.getColor()) {
				piece.setPosition(position);
				
				var newPosition = position.toCharArray();
				board[newPosition[1] - 49][newPosition[0] - 97] = piece;
				return true;
			}
			
			return false;
		}
		catch (IllegalPositionException e) {
			return false;
		}
	}
	
	public void move(String fromPosition, String toPosition) throws IllegalMoveException {
		try {
			var piece = getPiece(fromPosition);
			var legalMoves = piece.legalMoves();
			if(legalMoves.contains(toPosition)) {
				var success = placePiece(piece, toPosition);
				
				if(success) {
					var oldPosition = fromPosition.toCharArray();
					board[oldPosition[1] - 49][oldPosition[0] - 97] = null;
				}
			}
			else {
				throw new IllegalMoveException();
			}
		} 
		catch (IllegalPositionException e) {
			e.printStackTrace();
		}
	}
	

	public String toString(){    
		String chess="";    
		String upperLeft = "\u250C";    
		String upperRight = "\u2510";    
		String horizontalLine = "\u2500";    
		String horizontal3 = horizontalLine + "\u3000" + horizontalLine;    
		String verticalLine = "\u2502";    
		String upperT = "\u252C";    
		String bottomLeft = "\u2514";    
		String bottomRight = "\u2518";    
		String bottomT = "\u2534";    
		String plus = "\u253C";    
		String leftT = "\u251C";    
		String rightT = "\u2524";    
		String topLine = upperLeft;    
		
		for (int i = 0; i<7; i++) {        
			topLine += horizontal3 + upperT;    
		}    
		
		topLine += horizontal3 + upperRight;    
		String bottomLine = bottomLeft;
		
		for (int i = 0; i<7; i++) {        
			bottomLine += horizontal3 + bottomT;    
		}    
		
		bottomLine += horizontal3 + bottomRight;    
		chess+=topLine + "\n";    
		
		for (int row = 7; row >=0; row--) {        
			String midLine = "";        
			
			for (int col = 0; col < 8; col++) {            
				if(board[row][col]==null) {                
					midLine += verticalLine + " \u3000 ";            
					
				} 
				else {
					midLine += verticalLine + " "+board[row][col]+" ";
				}        
			}        
			
			midLine += verticalLine;        
			String midLine2 = leftT;        
			
			for (int i = 0; i<7; i++) {            
				midLine2 += horizontal3 + plus;        	
			}        
			
			midLine2 += horizontal3 + rightT;        
			chess+=midLine+ "\n";        
			
			if(row>=1) chess += midLine2 + "\n";    
		}    
		chess+=bottomLine;    
		return chess;	
	}

	
	public static void main(String[] args) throws IllegalMoveException {
		ChessBoard board = new ChessBoard();
		board.initialize();
		System.out.println(board);
		board.move("c2", "c4");
		System.out.println(board);
	}
}