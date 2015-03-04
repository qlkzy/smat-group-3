package uk.ac.york.modules.testing.input;

public class VariableHighlighter {

	private final String source;
	
	public VariableHighlighter(String source) {
		this.source = source;
	}

	public String highlight(String subString) {
		StringBuilder b = new StringBuilder();
		int start = 0;
		b.append("<html>");
		while (source.indexOf(subString, start) >= 0) {
			int end = source.indexOf(subString, start);
			b.append(source.substring(start, end));
			b.append("<font color=green>");
			b.append(subString);
			b.append("</font>");
			start = end + subString.length();
		}
		b.append(source.substring(start));
		b.append("</html>");
		return b.toString();
	}	
}
