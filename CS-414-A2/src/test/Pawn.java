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
		assertEquals(blackPiece.toString(), "\u265F");
		assertEquals(whitePiece.toString(), "\u2659");
	}
	
	@Test
	void legalMoves() throws IllegalPositionException {
		
		blackPiece.setPosition("a3");
		whitePiece.setPosition("b2");	
		var blackMoves = blackPiece.legalMoves();
		var whiteMoves = whitePiece.legalMoves();
		
		assertEquals(blackMoves.size(), 2);
		assertTrue(blackMoves.contains("a2"));
		assertTrue(blackMoves.contains("b2"));
		
		assertEquals(whiteMoves.size(), 2);
		assertTrue(whiteMoves.contains("b2"));
		assertTrue(whiteMoves.contains("b3"));
		
		var blackPawn = new chess.Pawn(board, Color.BLACK);
		var blackPawn1 = new chess.Pawn(board, Color.BLACK);
		var blackPawn2 = new chess.Pawn(board, Color.BLACK);
		blackPawn.setPosition("h1");
		blackPawn1.setPosition("h2");
		blackPawn2.setPosition("h8");
		
		assertEquals(blackPawn.legalMoves().size(), 0);
		assertEquals(blackPawn1.legalMoves().size(), 0);
		assertEquals(blackPawn2.legalMoves().size(), 0);
	}
}
