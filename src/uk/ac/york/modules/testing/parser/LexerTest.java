package uk.ac.york.modules.testing.parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class LexerTest {

	@Test
	public void shouldLex1() {
		Lexer lexer = new Lexer("1");
		Token tok = lexer.next();
		assertEquals(TokenType.LITERAL, tok.type);
		assertEquals("1", tok.text);
	}

	@Test
	public void shouldLex2() {
		Lexer lexer = new Lexer("2");
		Token tok = lexer.next();
		assertEquals(TokenType.LITERAL, tok.type);
		assertEquals("2", tok.text);
	}
	
	@Test
	public void shouldLexPlus() {
		Lexer lexer = new Lexer("+");
		Token tok = lexer.next();
		assertEquals(TokenType.PLUS, tok.type);
	}
	
	@Test
	public void shouldLex1ThenPlus() {
		Lexer lexer = new Lexer("1+");
		Token t1 = lexer.next();
		Token t2 = lexer.next();
		assertEquals(TokenType.LITERAL, t1.type);
		assertEquals("1", t1.text);
		assertEquals(TokenType.PLUS, t2.type);
	}
	
	@Test
	public void shouldLexTimes() {		
		Token t = new Lexer("*").next();
		assertEquals(TokenType.TIMES, t.type);
	}
	
	@Test
	public void shouldLexDivide() {
		Token t = new Lexer("/").next();
		assertEquals(TokenType.DIVIDE, t.type);
	}
	
	@Test
	public void shouldLexExp() {
		Token t = new Lexer("^").next();
		assertEquals(TokenType.EXP, t.type);
	}
	
	@Test
	public void shouldLexSin() {
		Token t = new Lexer("sin").next();
		assertEquals(TokenType.SIN, t.type);
	}
	
	@Test
	public void shouldLexX() {
		Token t = new Lexer("x").next();
		assertEquals(TokenType.X, t.type);
	}
	
	@Test
	public void shouldLexOParen() {
		Token t = new Lexer("(").next();
		assertEquals(TokenType.OPAREN, t.type);
	}
	
	@Test
	public void shouldLexCParen() {
		Token t = new Lexer(")").next();
		assertEquals(TokenType.CPAREN, t.type);
	}
}
