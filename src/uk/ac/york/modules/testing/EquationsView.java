package uk.ac.york.modules.testing;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class EquationsView extends JApplet {

	private static final long serialVersionUID = 1319302888145109147L;
	
	public static void main(String[] args) {
		
		Equation e = null;

		if (args.length != 1) {
			complain(args);
		}
		
		if (args[0].equals("Help")) {
			printHelp();
			System.exit(0);
		}
		
		if (args[0].equals("FirstOrder")) {
			e = Equation.createEquationFromType(FirstOrderEquation.class);
		} else if(args[0].equals("Sinus")) {
			e = Equation.createEquationFromType(SinusBasedEquation.class);
		} else if(args[0].equals("Fraction")) {
			e = Equation.createEquationFromType(FractionEquation.class);			
		} else if(args[0].equals("SecondOrder")) {
			e = Equation.createEquationFromType(SecondOrderEquation.class);			
		} else {
			complain(args);
		}

		JFrame f = new JFrame("Equation");
		f.setSize(800, 600);
		EquationPanel p = new EquationPanel(e);
		f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void complain(String[] args) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < args.length - 1; i++) {
			b.append(args[i]);
			b.append(" ");
		}
		if (args.length > 0) {
			b.append(args[args.length-1]);
		}
		final String plural = args.length > 1 ? "s" : "";
		System.err.println("Unrecognised argument" + plural + " \"" + b.toString() + "\"\n");
		printHelp();
		System.exit(0);
	}
	
	private static void printHelp() {
		System.out.println("Options are: \n"
				+ "\tFirstOrder:   f(x) = ax+b\n"
				+ "\tSecond Order: f(x) = ax^2+bx+c\n"
				+ "\tSinus:        f(x) = a*(sin(b+x)^c)+d\n"
				+ "\tFraction:     f(x) = a/(x+b)");
	}
}
