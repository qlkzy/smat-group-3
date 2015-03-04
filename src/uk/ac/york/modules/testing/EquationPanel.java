package uk.ac.york.modules.testing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

@SuppressWarnings({ "serial", "unchecked" })
public class EquationPanel extends JPanel {

	
	/**
	 * The equation.
	 */
	private final Equation equation;
	
	private final Series series;
	
	
	/**
	 * Takes an equation and assigns it to the class member.
	 * 
	 * @param equation
	 */
	public EquationPanel(Equation equation) {
		super();
		this.equation = equation;
		this.setBackground(Color.white);
		this.series = new Series(equation, 0, 10, 10.0/2000.0);

		nDigitsX=(int)Math.floor(Math.log10(series.maxX));
		nDigitsY=(int)Math.floor(Math.log10(series.maxY));
		leftBorder = 20+nDigitsY*7;
	}

	/**
	 * The size of the border on the left part.
	 */
	int leftBorder = 25;

	/**
	 * The size of the border on the right part.
	 */
	int rightBorder = 25;

	/**
	 * The size of the border on the lower part.
	 */
	int horizontalBorder = 25;

	/**
	 * The number of digits of the scale of X.
	 */
	int nDigitsX = 1;

	/**
	 * The number of digits of the scale of Y.
	 */
	int nDigitsY = 1;
	
	
	/**
	 * Popup menu on this graph.
	 */
	JPopupMenu popup=null;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// we get the graph component
		Graphics2D g2 = (Graphics2D)g;
		// we get the size of the area to paint 
		double w = getWidth();
		double h = getHeight();
		
		// we can't draw on a zero-size canvas
		// hopefully this is a transient condition
		if (w <= 0 || h <= 0)
			return;
		
		// Draw y-axis.
		g2.draw(new Line2D.Double(leftBorder, horizontalBorder, leftBorder, h-horizontalBorder));
		// Draw x-axis.
		g2.draw(new Line2D.Double(leftBorder, h-horizontalBorder, w-rightBorder, h-horizontalBorder));
		g2.drawString("y="+equation.toString(), leftBorder , horizontalBorder-5);
		// we draw the y-labels
		double ystep = Math.pow(10, nDigitsY);
		if ((Math.pow(10, nDigitsY)*2)>series.maxY) 
			ystep = Math.pow(10, nDigitsY-1)*2;

		for (int i = 0; i<20; i++) {
			int grade = (int)(i*ystep);
			if (grade>series.maxY) {
				break;
			}
			double y1=h-horizontalBorder-(h-2*horizontalBorder)*grade/series.maxY;
			g2.draw(new Line2D.Double(leftBorder-1,y1,leftBorder+1,y1));
			g2.drawString(""+grade, 5, (int)y1+5);
		}

		// we draw the x-labels
		double xstep = Math.pow(10, nDigitsX);
		if ((Math.pow(10, nDigitsX)*2)>series.maxX) 
			xstep = Math.pow(10, nDigitsX-1)*2;
		for (int i = 0; i<10; i++) {
			int grade = (int)(i*xstep);
			if (grade>series.maxX) {
				break;
			}
			double x1=leftBorder+(w-leftBorder-rightBorder)*grade/series.maxX;
			g2.draw(new Line2D.Double(x1,h-horizontalBorder+1,x1,h-horizontalBorder-1));
			g2.drawString(""+grade, (int)(x1-(nDigitsX*4)-2), (int) (h-horizontalBorder+17));
		}

		// we draw data points.
		try {
			g2.setPaint(Color.red);
			for (Point p : series) {
				double x = leftBorder + (w-leftBorder-rightBorder)*p.x/series.maxX;
				double y =  h - horizontalBorder - (h-2*horizontalBorder)*p.y/series.maxY;
				g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
			}
		} catch (NullPointerException e) {
			System.out.println("Ouch");
		}
	}
}
