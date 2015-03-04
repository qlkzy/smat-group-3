package uk.ac.york.modules.testing.parser;

public enum TokenType {
	
	LITERAL("^\\d+(\\.\\d+)?"),
	PLUS("^\\+"),
	TIMES("^\\*"),
	DIVIDE("^/"),
	EXP("^\\^"),
	SIN("^sin"),
	X("^x"),
	OPAREN("^\\("),
	CPAREN("^\\)");
		
	public final String pattern;
	
	private TokenType(String pattern) {
		this.pattern = pattern;
	}
}
