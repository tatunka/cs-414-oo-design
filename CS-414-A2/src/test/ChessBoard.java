package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.ChessPiece;
import chess.IllegalMoveException;
import chess.IllegalPositionException;

class ChessBoard {
	
	private static chess.ChessBoard board = new chess.ChessBoard();
	private static char[] cols = new char[] {'a','b','c','d','e','f','g','h'};

	@BeforeEach
	void setUp() throws Exception {
		board = new chess.ChessBoard();
		board.initialize();
	}
	
	@Test
	void initialize() throws ClassNotFoundException, IllegalPositionException {
		var pieces = new Class[] {
				Class.forName("class.Rook"), 
				Class.forName("classs.Knight"),
				Class.forName("class.Bishop"),
				Class.forName("class.King"),
				Class.forName("class.Queen"),
				Class.forName("class.Bishop"),
				Class.forName("classs.Knight"),
				Class.forName("class.Rook"), 
		};
		
		for(var x = 0; x < 8; x++) {
			var whitePiece = board.getPiece(String.valueOf(cols[x]) + "1");
			assertEquals(whitePiece.getColor(), ChessPiece.Color.WHITE);
			assertEquals(pieces[x], whitePiece.getClass());
			
			var whitePawn = board.getPiece(String.valueOf(cols[x]) + "2");
			assertEquals(whitePiece.getColor(), ChessPiece.Color.WHITE);
			assertEquals(Class.forName("class.Pawn"), whitePawn.getClass());
			
			var blackPiece = board.getPiece(String.valueOf(cols[x]) + "8");
			assertEquals(blackPiece.getColor(), ChessPiece.Color.BLACK);
			assertEquals(pieces[x], blackPiece.getClass());
			
			var blackPawn = board.getPiece(String.valueOf(cols[x]) + "7");
			assertEquals(blackPawn.getColor(), ChessPiece.Color.BLACK);
			assertEquals(Class.forName("class.Pawn"), blackPawn.getClass());
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
		board.move("a2", "a3");
		var wPawn1 = board.getPiece("a3");
		var nullPiece = board.getPiece("a2");
		assertEquals(wPawn1.getColor(), chess.ChessPiece.Color.WHITE);
		assertEquals(wPawn1.getClass(), Class.forName("chess.Pawn"));
		assertNull(nullPiece);
		
		try {
			board.move("a3", "a2");
			fail("Did not catch illegal move.");
		}
		catch(IllegalMoveException e) {
			try {
				board.move("b1", "d2");
				fail("Did not catch illegal move.");
			}
			catch(IllegalMoveException e1) {
				var wKnight1 = board.getPiece("b1");
				assertEquals(wKnight1.getColor(), chess.ChessPiece.Color.WHITE);
				assertEquals(wKnight1.getClass(), Class.forName("chess.Knight"));
			}
		}
	}
}
