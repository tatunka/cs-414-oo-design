package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.ChessPiece.Color;
import chess.IllegalPositionException;

class Bishop {
	private static chess.ChessBoard board;
	private static chess.Bishop blackPiece;
	private static chess.Bishop whitePiece;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		board = new chess.ChessBoard();
		blackPiece = new chess.Bishop(board, Color.BLACK);
		whitePiece = new chess.Bishop(board, Color.WHITE);
		
		blackPiece.setPosition("a1");
		whitePiece.setPosition("a2");
	}

	@AfterEach
	void tearDown() throws Exception {
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
		assertEquals(blackPiece.toString(), "\u265D");
		assertEquals(whitePiece.toString(), "\u2657");
	}
	
	@Test
	void legalMoves() throws IllegalPositionException {
		var blackPawn = new chess.Pawn(board, Color.BLACK);
		var blackBishop = new chess.Bishop(board, Color.BLACK);
		blackPawn.setPosition("g2");
		blackBishop.setPosition("h1");
		
		blackPiece.setPosition("a1");
		whitePiece.setPosition("b2");
		var blackMoves = blackPiece.legalMoves();
		var whiteMoves = whitePiece.legalMoves();
		
		assertEquals(blackMoves.size(), 7);
		assertTrue(blackMoves.contains("b2"));
		assertTrue(blackMoves.contains("c3"));
		assertTrue(blackMoves.contains("d4"));
		assertTrue(blackMoves.contains("e5"));
		assertTrue(blackMoves.contains("f6"));
		assertTrue(blackMoves.contains("g7"));
		assertTrue(blackMoves.contains("h8"));
		
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
