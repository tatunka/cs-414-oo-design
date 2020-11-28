package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.IllegalPositionException;
import chess.ChessPiece.Color;

class Pawn {

	private static chess.ChessBoard board;
	private static chess.Pawn blackPiece;
	private static chess.Pawn whitePiece;

	@BeforeEach
	void setUp() throws Exception {
		board = new chess.ChessBoard();
		blackPiece = new chess.Pawn(board, Color.BLACK);
		whitePiece = new chess.Pawn(board, Color.WHITE);
		
		board.placePiece(blackPiece, "a3");
		board.placePiece(whitePiece,  "b2");
	}

	@Test
	void getColor() {
		assertEquals(blackPiece.getColor(), Color.BLACK);
		assertEquals(whitePiece.getColor(), Color.WHITE);
	}
	
	@Test
	void setPosition() throws IllegalPositionException {
		try {
			blackPiece.setPosition("11");
			fail("Did not catch illegal position");
		}
		catch(IllegalPositionException e) {}
		try {
			blackPiece.setPosition("1");
			fail("Did not catch illegal position");
		}
		catch(IllegalPositionException e) {}
		try {
			blackPiece.setPosition("xx");
			fail("Did not catch illegal position");
		}
		catch(IllegalPositionException e) {}
		try {
			blackPiece.setPosition("a9");
		}
		catch(IllegalPositionException e) {}
		
		blackPiece.setPosition("g1");
		assertEquals(blackPiece.getPosition(), "g1");
		assertEquals(whitePiece.getPosition(), "b2");
	}
	
	@Test
	void getPosition() {
		assertEquals(blackPiece.getPosition(), "a3");
		assertEquals(whitePiece.getPosition(), "b2");
	}
	
	@Test
	void toStringTest() {
		assertEquals(blackPiece.toString(), "\u265F");
		assertEquals(whitePiece.toString(), "\u2659");
	}
	
	@Test
	void legalMoves() throws IllegalPositionException {	
		var blackMoves = blackPiece.legalMoves();
		var whiteMoves = whitePiece.legalMoves();
		
		assertEquals(blackMoves.size(), 2);
		assertTrue(blackMoves.contains("a2"));
		assertTrue(blackMoves.contains("b2"));
		
		assertEquals(whiteMoves.size(), 3);
		assertTrue(whiteMoves.contains("a3"));
		assertTrue(whiteMoves.contains("b3"));
		assertTrue(whiteMoves.contains("b4"));
		
		var blackPawn = new chess.Pawn(board, Color.BLACK);
		var blackPawn1 = new chess.Pawn(board, Color.BLACK);
		board.placePiece(blackPawn, "h1");
		board.placePiece(blackPawn1, "h2");
		assertEquals(blackPawn.legalMoves().size(), 0);
		assertEquals(blackPawn1.legalMoves().size(), 0);
		
		var blackPawn2 = new chess.Pawn(board, Color.BLACK);
		board.placePiece(blackPawn2, "h8");
		var blackPawn2Moves = blackPawn2.legalMoves();
		assertEquals(blackPawn2Moves.size(), 1);
		assertTrue(blackPawn2Moves.contains("h7"));
	}
}
