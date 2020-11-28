package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.IllegalPositionException;
import chess.ChessPiece.Color;

class Queen {

	private static chess.ChessBoard board;
	private static chess.Queen blackPiece;
	private static chess.Queen whitePiece;

	@BeforeEach
	void setUp() throws Exception {
		board = new chess.ChessBoard();
		blackPiece = new chess.Queen(board, Color.BLACK);
		whitePiece = new chess.Queen(board, Color.WHITE);
		
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
		assertEquals(blackPiece.toString(), "\u265B");
		assertEquals(whitePiece.toString(), "\u2655");
	}
	
	@Test
	void legalMoves() throws IllegalPositionException {
		var blackMoves = blackPiece.legalMoves();
		var whiteMoves = whitePiece.legalMoves();
		
		assertEquals(blackMoves.size(), 0);
		assertEquals(whiteMoves.size(), 0);
	}
}
