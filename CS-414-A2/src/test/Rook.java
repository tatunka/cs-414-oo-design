package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.IllegalPositionException;
import chess.ChessPiece.Color;

class Rook {
	private static chess.ChessBoard board;
	private static chess.Rook blackPiece;
	private static chess.Rook whitePiece;

	@BeforeEach
	void setUp() throws Exception {
		board = new chess.ChessBoard();
		blackPiece = new chess.Rook(board, Color.BLACK);
		whitePiece = new chess.Rook(board, Color.WHITE);
		
		board.placePiece(blackPiece, "a1");
		board.placePiece(whitePiece, "b1");
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
		assertEquals(whitePiece.getPosition(), "b1");
	}
	
	@Test
	void getPosition() {
		assertEquals(blackPiece.getPosition(), "a1");
		assertEquals(whitePiece.getPosition(), "b1");
	}
	
	@Test
	void toStringTest() {
		assertEquals(blackPiece.toString(), "\u265C");
		assertEquals(whitePiece.toString(), "\u2656");
	}
	
	@Test
	void legalMoves() throws IllegalPositionException {
		
		var blackMoves = blackPiece.legalMoves();
		var whiteMoves = whitePiece.legalMoves();
		
		assertEquals(blackMoves.size(), 8);
		assertTrue(blackMoves.contains("a2"));
		assertTrue(blackMoves.contains("a3"));
		assertTrue(blackMoves.contains("a4"));
		assertTrue(blackMoves.contains("a5"));
		assertTrue(blackMoves.contains("a6"));
		assertTrue(blackMoves.contains("a7"));
		assertTrue(blackMoves.contains("a8"));
		assertTrue(blackMoves.contains("b1"));

		assertEquals(whiteMoves.size(), 14);
		assertTrue(whiteMoves.contains("a1"));
		assertTrue(whiteMoves.contains("c1"));
		assertTrue(whiteMoves.contains("d1"));
		assertTrue(whiteMoves.contains("e1"));
		assertTrue(whiteMoves.contains("f1"));
		assertTrue(whiteMoves.contains("g1"));
		assertTrue(whiteMoves.contains("h1"));
		assertTrue(whiteMoves.contains("b2"));
		assertTrue(whiteMoves.contains("b3"));
		assertTrue(whiteMoves.contains("b4"));
		assertTrue(whiteMoves.contains("b5"));
		assertTrue(whiteMoves.contains("b6"));
		assertTrue(whiteMoves.contains("b7"));
		assertTrue(whiteMoves.contains("b8"));
		
		var blackRook = new chess.Rook(board, Color.BLACK);
		var blackRook1 = new chess.Rook(board, Color.BLACK);
		var blackRook2 = new chess.Rook(board, Color.BLACK);
		board.placePiece(blackRook,  "h1");
		board.placePiece(blackRook1, "h2");
		board.placePiece(blackRook2, "g1");
		var blackRookMoves = blackRook.legalMoves();
		var blackRook1Moves = blackRook1.legalMoves();
		var blackRook2Moves = blackRook2.legalMoves();
		
		assertEquals(blackRookMoves.size(), 0);
		assertEquals(blackRook1Moves.size(), 13);
		assertTrue(blackRook1Moves.contains("h3"));
		assertTrue(blackRook1Moves.contains("h4"));
		assertTrue(blackRook1Moves.contains("h5"));
		assertTrue(blackRook1Moves.contains("h6"));
		assertTrue(blackRook1Moves.contains("h7"));
		assertTrue(blackRook1Moves.contains("h8"));
		assertTrue(blackRook1Moves.contains("a2"));
		assertTrue(blackRook1Moves.contains("b2"));
		assertTrue(blackRook1Moves.contains("c2"));
		assertTrue(blackRook1Moves.contains("d2"));
		assertTrue(blackRook1Moves.contains("e2"));
		assertTrue(blackRook1Moves.contains("f2"));
		assertTrue(blackRook1Moves.contains("g2"));
		
		assertEquals(blackRook2Moves.size(), 12);
		assertTrue(blackRook2Moves.contains("g2"));
		assertTrue(blackRook2Moves.contains("g3"));
		assertTrue(blackRook2Moves.contains("g4"));
		assertTrue(blackRook2Moves.contains("g5"));
		assertTrue(blackRook2Moves.contains("g6"));
		assertTrue(blackRook2Moves.contains("g7"));
		assertTrue(blackRook2Moves.contains("g8"));
		assertTrue(blackRook2Moves.contains("b1"));
		assertTrue(blackRook2Moves.contains("c1"));
		assertTrue(blackRook2Moves.contains("d1"));
		assertTrue(blackRook2Moves.contains("e1"));
	}
}
