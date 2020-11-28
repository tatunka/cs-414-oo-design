package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.ChessPiece;
import chess.ChessPiece.Color;
import chess.IllegalMoveException;
import chess.IllegalPositionException;

class ChessBoard {
	
	private static chess.ChessBoard board = new chess.ChessBoard();

	@BeforeEach
	void setUp() throws Exception {
		board = new chess.ChessBoard();
		board.initialize();
	}
	
	@Test
	void initialize() throws ClassNotFoundException, IllegalPositionException {
		var pieces = new Class[] {
				Class.forName("chess.Rook"), 
				Class.forName("chess.Knight"),
				Class.forName("chess.Bishop"),
				Class.forName("chess.Queen"),
				Class.forName("chess.King"),
				Class.forName("chess.Bishop"),
				Class.forName("chess.Knight"),
				Class.forName("chess.Rook"), 
		};
		
		for(var col = 0; col < 8; col++) {
			var whitePiece = board.getPiece(String.valueOf((char)(col + 97)) + "1");
			assertEquals(whitePiece.getColor(), ChessPiece.Color.WHITE);
			assertEquals(pieces[col], whitePiece.getClass());
			
			var whitePawn = board.getPiece(String.valueOf((char)(col + 97)) + "2");
			assertEquals(whitePiece.getColor(), ChessPiece.Color.WHITE);
			assertEquals(Class.forName("chess.Pawn"), whitePawn.getClass());
			
			var blackPiece = board.getPiece(String.valueOf((char)(col + 97)) + "8");
			assertEquals(blackPiece.getColor(), ChessPiece.Color.BLACK);
			assertEquals(pieces[col], blackPiece.getClass());
			
			var blackPawn = board.getPiece(String.valueOf((char)(col + 97)) + "7");
			assertEquals(blackPawn.getColor(), ChessPiece.Color.BLACK);
			assertEquals(Class.forName("chess.Pawn"), blackPawn.getClass());
			
			for(var row = 2; row < 6; row++) {
				var c = String.valueOf((char)(col + 97));
				var r = String.valueOf((char)(row + 49));
				var nullPiece = board.getPiece(c + r);
				assertNull(nullPiece);
			}
		}	
	}

	@Test
	void getPiece() throws IllegalPositionException, ClassNotFoundException {
		try {
			board.getPiece("00");
			fail("Did not catch illegal move.");
		}
		catch(chess.IllegalPositionException e) {}
		try {
			board.getPiece("xxxxxxxx");
			fail("Did not catch illegal move.");
		}
		catch(chess.IllegalPositionException e) {}
		try {
			board.getPiece("1q");
			fail("Did not catch illegal move.");
		}
		catch(chess.IllegalPositionException e) {}
		try {
			board.getPiece("0");
			fail("Did not catch illegal move.");
		}
		catch(chess.IllegalPositionException e) {}
		try {
			board.getPiece("x9");
			fail("Did not catch illegal move.");
		}
		catch(chess.IllegalPositionException e) {}
		try {
			board.getPiece("");
			fail("Did not catch illegal move.");
		}
		catch(chess.IllegalPositionException e) {}
		try {
			board.getPiece("q1");
			fail("Did not catch illegal move.");
		}
		catch(chess.IllegalPositionException e) {}
		try {
			board.getPiece("a9");
			fail("Did not catch illegal move.");
		}
		catch(chess.IllegalPositionException e) {}
		
		var blankPiece = board.getPiece("a3");
		assertNull(blankPiece);
		
		var wPawn1 = board.getPiece("a2");
		assertEquals(wPawn1.getColor(), chess.ChessPiece.Color.WHITE);
		assertEquals(wPawn1.getClass(), Class.forName("chess.Pawn"));
		assertEquals(wPawn1.getPosition(), "a2");
	}
	
	@Test
	void placePiece() throws IllegalPositionException {
		var wPawn1 = board.getPiece("a2");
		board.placePiece(wPawn1, "a4");
		assertEquals(wPawn1.getPosition(), "a4");
		
		board.placePiece(wPawn1, "a5");
		board.placePiece(wPawn1, "a6");
		board.placePiece(wPawn1, "b7");
		assertEquals(wPawn1.getPosition(), "b7");
		assertEquals(wPawn1, board.getPiece("b7"));
	}
	
	@Test
	void move() throws IllegalPositionException, IllegalMoveException, ClassNotFoundException {
		//move white pawn
		board.move("a2", "a4");
		//move black pawn
		board.move("b7", "b5");
		//capture white pawn with black pawn
		board.move("b5", "a4");
		//move black bishop
		board.move("c8", "a6");
		//capture black pawn with white rook
		board.move("a1","a4");
		//move white pawn
		board.move("d2", "d3");
		//move king
		board.move("e1", "d2");
		board.move("d2", "e3");
		
		var rook = board.getPiece("a4");
		assertEquals(rook.getClass(), Class.forName("chess.Rook"));
		assertEquals(rook.getColor(), Color.WHITE);
		var bishop = board.getPiece("a6");
		assertEquals(bishop.getClass(), Class.forName("chess.Bishop"));
		assertEquals(bishop.getColor(), Color.BLACK);
		var pawn = board.getPiece("d3");
		assertEquals(pawn.getClass(), Class.forName("chess.Pawn"));
		assertEquals(pawn.getColor(), Color.WHITE);
		var king = board.getPiece("e3");
		assertEquals(king.getClass(), Class.forName("chess.King"));
		assertEquals(king.getColor(), Color.WHITE);
		
		try {
			board.move("d3", "e3");
			fail("Did not catch illegal move");
		}
		catch(IllegalMoveException e) {}
		try {
			board.move("h2", "g3");
			fail("Pawns can only move diagonal to capture");
		}
		catch(IllegalMoveException e) {}
		try {
			board.move("b1", "c3");
			fail("Did not catch illegal move");
		}
		catch(IllegalMoveException e) {}
		try {
			board.move("b1", "c3");
			fail("Knights cannot move");
		}
		catch(IllegalMoveException e) {}
		try {
			board.move("d1", "d2");
			fail("Queens cannot move");
		}
		catch(IllegalMoveException e) {}
	}
}
