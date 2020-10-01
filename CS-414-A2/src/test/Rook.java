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
		
		blackPiece.setPosition("a1");
		whitePiece.setPosition("a2");
	}

	@Test
	void getColor() {
		assertEquals(blackPiece.getColor(), Color.BLACK);
		assertEquals(whitePiece.getColor(), Color.WHITE);
	}
	
	@Test
	void setPosition() throws IllegalPositionException {
		var blackBishop = new chess.Bishop(board, Color.BLACK);
		blackBishop.setPosition("b1");
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
			blackPiece.setPosition("b1");
			fail("Did not catch illegal position");
		}
		catch(IllegalPositionException e) {}
		
		assertEquals(blackPiece.getPosition(), "a1");
		assertEquals(whitePiece.getPosition(), "a2");
	}
	
	@Test
	void getPosition() {
		assertEquals(blackPiece.getPosition(), "a1");
		assertEquals(whitePiece.getPosition(), "a2");
	}
	
	@Test
	void toStringTest() {
		assertEquals(blackPiece.toString(), "\u265C");
		assertEquals(whitePiece.toString(), "\u2656");
	}
	
	@Test
	void legalMoves() throws IllegalPositionException {
		
		blackPiece.setPosition("a1");
		whitePiece.setPosition("b1");	
		var blackMoves = blackPiece.legalMoves();
		var whiteMoves = whitePiece.legalMoves();
		
		assertEquals(blackMoves.size(), 14);
		assertTrue(whiteMoves.contains("a2"));
		assertTrue(whiteMoves.contains("a3"));
		assertTrue(whiteMoves.contains("a4"));
		assertTrue(whiteMoves.contains("a5"));
		assertTrue(whiteMoves.contains("a6"));
		assertTrue(whiteMoves.contains("a7"));
		assertTrue(whiteMoves.contains("a8"));
		assertTrue(whiteMoves.contains("b1"));
		assertTrue(whiteMoves.contains("c1"));
		assertTrue(whiteMoves.contains("d1"));
		assertTrue(whiteMoves.contains("e1"));
		assertTrue(whiteMoves.contains("f1"));
		assertTrue(whiteMoves.contains("g1"));
		assertTrue(whiteMoves.contains("h1"));

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
		blackRook.setPosition("h1");
		blackRook1.setPosition("h2");
		blackRook2.setPosition("g1");
		
		assertEquals(blackRook.legalMoves().size(), 0);
		assertEquals(blackRook1.legalMoves().size(), 13);
		assertTrue(whiteMoves.contains("h3"));
		assertTrue(whiteMoves.contains("h4"));
		assertTrue(whiteMoves.contains("h5"));
		assertTrue(whiteMoves.contains("h6"));
		assertTrue(whiteMoves.contains("h7"));
		assertTrue(whiteMoves.contains("h8"));
		assertTrue(whiteMoves.contains("a2"));
		assertTrue(whiteMoves.contains("b2"));
		assertTrue(whiteMoves.contains("c2"));
		assertTrue(whiteMoves.contains("d2"));
		assertTrue(whiteMoves.contains("e2"));
		assertTrue(whiteMoves.contains("f2"));
		assertTrue(whiteMoves.contains("g2"));
		assertEquals(blackRook2.legalMoves().size(), 13);
		assertTrue(whiteMoves.contains("g2"));
		assertTrue(whiteMoves.contains("g3"));
		assertTrue(whiteMoves.contains("g4"));
		assertTrue(whiteMoves.contains("g5"));
		assertTrue(whiteMoves.contains("g6"));
		assertTrue(whiteMoves.contains("g7"));
		assertTrue(whiteMoves.contains("g8"));
		assertTrue(whiteMoves.contains("b1"));
		assertTrue(whiteMoves.contains("c1"));
		assertTrue(whiteMoves.contains("d1"));
		assertTrue(whiteMoves.contains("e1"));
		assertTrue(whiteMoves.contains("f1"));
	}
}
