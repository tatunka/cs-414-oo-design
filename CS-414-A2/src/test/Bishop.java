package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.ChessPiece.Color;
import chess.IllegalMoveException;
import chess.IllegalPositionException;

class Bishop {
	private static chess.ChessBoard board;
	private static chess.Bishop blackPiece;
	private static chess.Bishop whitePiece;

	@BeforeEach
	void setUp() throws Exception {
		board = new chess.ChessBoard();
		blackPiece = new chess.Bishop(board, Color.BLACK);
		whitePiece = new chess.Bishop(board, Color.WHITE);
		
		board.placePiece(blackPiece, "a1");
		board.placePiece(whitePiece, "a2");
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
		assertEquals(whitePiece.getPosition(), "a2");
	}
	
	@Test
	void getPosition() {
		assertEquals(blackPiece.getPosition(), "a1");
		assertEquals(whitePiece.getPosition(), "a2");
	}
	
	@Test
	void toStringTest() {
		assertEquals(blackPiece.toString(), "\u265D");
		assertEquals(whitePiece.toString(), "\u2657");
	}
	
	@Test
	void legalMoves() throws IllegalPositionException, IllegalMoveException {
		var blackPawn = new chess.Pawn(board, Color.BLACK);
		var blackBishop = new chess.Bishop(board, Color.BLACK);
		var whiteBishop = new chess.Bishop(board,  Color.WHITE);
		board.placePiece(blackPawn, "g2");
		board.placePiece(blackBishop, "h1");
		board.placePiece(whiteBishop, "b2");
	
		var blackMoves = blackPiece.legalMoves();
		var whiteMoves = whiteBishop.legalMoves();
		
		assertEquals(blackMoves.size(), 1);
		assertTrue(blackMoves.contains("b2"));
		
		assertEquals(whiteMoves.size(), 9);
		assertTrue(whiteMoves.contains("a1"));
		assertTrue(whiteMoves.contains("c1"));
		assertTrue(whiteMoves.contains("a3"));
		assertTrue(whiteMoves.contains("c3"));
		assertTrue(whiteMoves.contains("d4"));
		assertTrue(whiteMoves.contains("e5"));
		assertTrue(whiteMoves.contains("f6"));
		assertTrue(whiteMoves.contains("g7"));
		assertTrue(whiteMoves.contains("h8"));
		
		var bishopMoves = blackBishop.legalMoves();
		assertEquals(bishopMoves.size(), 0);
	}

}
