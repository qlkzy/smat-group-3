package uk.ac.york.modules.testing.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer implements Iterator<Token>, Iterable<Token> {

	private static class Recogniser {
		private final Pattern pattern;
		private final TokenType type;

		public Recogniser(Pattern pattern, TokenType token) {
			this.pattern = pattern;
			this.type = token;
		}
	}
	
	private static final ArrayList<Recogniser> patterns;
	
	static {
		patterns = new ArrayList<Recogniser>();
		for (TokenType t : TokenType.values()) {
			patterns.add(new Recogniser(Pattern.compile(t.pattern), t));
		}		
	}
	
	private String text;
	
	public Lexer(String text) {
		this.text = text;
	}

	@Override
	public Iterator<Token> iterator() {
		return new Lexer(text);
	}
	
	@Override
	public boolean hasNext() {
		for (Recogniser recogniser : patterns) {
			if (recogniser.pattern.matcher(text).find()) {
				return true;
			}
		}
		return false;
	}	
	
	@Override
	public Token next() {
		for (Recogniser recogniser : patterns) {
			Matcher matcher = recogniser.pattern.matcher(text); 
			if (matcher.find()) {			
				text = text.substring(matcher.end());
				return new Token(recogniser.type, matcher.group());
			}
		}
		throw new NoSuchElementException();
	}

}
