/**
 * 
 */
package uk.ac.york.modules.testing;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;

import uk.ac.york.modules.testing.input.VariableInputDialog;
import uk.ac.york.modules.testing.input.VariableInputDialog.Cancelled;

/**
 * This class represents an equation.
 * Note that there should be only one constructor for a given equation type with only double arguments.
 * 
 * @author Manuel Oriol (manuel@cs.york.ac.uk)
 * @date Feb 14, 2010
 *
 */
public abstract class Equation {

	
	/**
	 * Static method creating an instance of a given Equation type. 
	 * The method asks values of parameters through option panes.
	 * 
	 * @param equationType the class of the equation 
	 * @return the Equation
	 */
	@SuppressWarnings("unchecked")
	public static Equation createEquationFromType(Class equationType) {
		try {
			Constructor c =  equationType.getConstructors()[0];
			int n_arguments = c.getParameterTypes().length;
			Object[] arguments = new Double [n_arguments];

			Method m = equationType.getMethod("description");
			String description = (String)m.invoke(null);

			for (int i = 0; i < n_arguments; i++) {
				//ask for values
				/*
				String s = JOptionPane.showInputDialog(null, ((char)(((byte)'a')+i))+" =", 
						"Enter argument", JOptionPane.QUESTION_MESSAGE);
				arguments[i] = Double.parseDouble(s);
				*/
				String varname = ""+(char)(((byte)'a')+i);
				arguments[i] = VariableInputDialog.prompt(varname, description);
			}
			return (Equation)c.newInstance(arguments);
		} catch (Cancelled c) {	
			System.out.println("Equation viewing cancelled");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		// there is no sane way of reaching here...
		return null;
	}
	
	@Override
	public String toString() {
		return "A "+this.getClass().getName();
	}
	
	/**
	 * Calculates the value of this equation for x.
	 * 
	 * @param x the x to use with f(x)
	 * @return the result for this equation given x.
	 */
	public abstract double of(double x);
}
