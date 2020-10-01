package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.IllegalPositionException;
import chess.ChessPiece.Color;

class King {

	private static chess.ChessBoard board;
	private static chess.King blackPiece;
	private static chess.King whitePiece;

	@BeforeEach
	void setUp() throws Exception {
		board = new chess.ChessBoard();
		blackPiece = new chess.King(board, Color.BLACK);
		whitePiece = new chess.King(board, Color.WHITE);
		
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
		assertEquals(blackPiece.toString(), "\u265A");
		assertEquals(whitePiece.toString(), "\u2654");
	}
	
	@Test
	void legalMoves() throws IllegalPositionException {
				
		blackPiece.setPosition("a1");
		whitePiece.setPosition("b2");
		var blackMoves = blackPiece.legalMoves();
		var whiteMoves = whitePiece.legalMoves();
		
		assertEquals(blackMoves.size(), 3);
		assertTrue(blackMoves.contains("a2"));
		assertTrue(blackMoves.contains("b2"));
		assertTrue(blackMoves.contains("b1"));
		
		assertEquals(whiteMoves.size(), 9);
		assertTrue(whiteMoves.contains("a1"));
		assertTrue(whiteMoves.contains("a2"));
		assertTrue(whiteMoves.contains("a3"));
		assertTrue(whiteMoves.contains("c1"));
		assertTrue(whiteMoves.contains("c2"));
		assertTrue(whiteMoves.contains("c3"));
		assertTrue(whiteMoves.contains("b1"));
		assertTrue(whiteMoves.contains("b3"));
		
		var blackPawn = new chess.Pawn(board, Color.BLACK);
		var blackPawn1 = new chess.Pawn(board, Color.BLACK);
		var blackPawn2 = new chess.Pawn(board, Color.BLACK);
		var blackKing = new chess.King(board, Color.BLACK);
		blackPawn.setPosition("g2");
		blackPawn1.setPosition("g1");
		blackPawn2.setPosition("h2");
		blackKing.setPosition("h1");
		
		var kingMoves = blackKing.legalMoves();
		assertEquals(kingMoves.size(), 0);
	}

}
