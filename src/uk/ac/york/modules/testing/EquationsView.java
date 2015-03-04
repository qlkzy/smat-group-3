package uk.ac.york.modules.testing;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class EquationsView extends JApplet {

	private static final long serialVersionUID = 1319302888145109147L;

	public static void main(String[] args) {
		
		Equation e = null;
		
		if (args.length!=1) 
			return;
		
		if (args[0].equals("FirstOrder")) {
			e = Equation.createEquationFromType(FirstOrderEquation.class);
		} else if(args[0].equals("Sinus")) {
			e = Equation.createEquationFromType(SinusBasedEquation.class);
		} else if(args[0].equals("Fraction")) {
			e = Equation.createEquationFromType(FractionEquation.class);			
		} else if(args[0].equals("SecondOrder")) {
			e = Equation.createEquationFromType(SecondOrderEquation.class);
		} else {
			System.out.println("Options are: \n"
					+ "\tFirstOrder:   f(x) = ax+b\n"
					+ "\tSecond Order: f(x) = ax^2+bx+c\n"
					+ "\tSinus:        f(x) = a*(sin(b+x)^c)+d\n"
					+ "\tFraction:     f(x) = a/(x+b)");
		}

		JFrame f = new JFrame("Equation");
		f.setSize(800, 600);
		EquationPanel p = new EquationPanel(e);
		f.add(p);
		f.setVisible(true);
	}
}
