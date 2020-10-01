package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.IllegalPositionException;
import chess.ChessPiece.Color;

class Knight {

	private static chess.ChessBoard board;
	private static chess.Knight blackPiece;
	private static chess.Knight whitePiece;

	@BeforeEach
	void setUp() throws Exception {
		board = new chess.ChessBoard();
		blackPiece = new chess.Knight(board, Color.BLACK);
		whitePiece = new chess.Knight(board, Color.WHITE);
		
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
		assertEquals(blackPiece.toString(), "\u265E");
		assertEquals(whitePiece.toString(), "\u2658");
	}
	
	@Test
	void legalMoves() throws IllegalPositionException {
		var blackMoves = blackPiece.legalMoves();
		var whiteMoves = whitePiece.legalMoves();
		
		assertEquals(blackMoves.size(), 0);
		assertEquals(whiteMoves.size(), 0);
	}

}
