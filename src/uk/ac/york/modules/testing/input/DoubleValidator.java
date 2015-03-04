package uk.ac.york.modules.testing.input;

public class DoubleValidator {
		
	public static boolean isValid(String input) {
		try {
			Double d = new Double(input);
			if (d.isInfinite())	return false;
			if (d.isNaN()) 		return false;
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
