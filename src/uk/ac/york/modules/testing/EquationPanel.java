package uk.ac.york.modules.testing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;

import javax.swing.JPanel;

public class EquationPanel extends JPanel {
	private static final long serialVersionUID = -1767320964962065783L;
	private static final int borderWidth = 50;
	
	
	private final Equation equation;
	
	private final Series series;
	private final double maxY;
	private final double minY;

	private final DecimalFormat yScaleFormat;
	
	public EquationPanel(Equation equation) {
		super();
		this.equation = equation;
		this.setBackground(Color.white);
		this.series = new Series(equation, 0, 10, 10.0/2000.0);
		
		// cleverness about min/max y values
		// this is to handle functions with an enormous range
		
		// initially define the max/min in terms of the quartiles
		double maxY = series.yUpperQuartile + (series.yUpperQuartile - series.yMedian) * 2;
		double minY = series.yLowerQuartile - (series.yMedian - series.yLowerQuartile) * 2;				
		
		// if that was too pessimistic, clamp to the actual values
		if (maxY > series.maxY) {
			maxY = series.maxY;
		}
		if (minY < series.minY) {
			minY = series.minY;
		}
		
		// if we've only left off a 'small' amount of the graph, allow it on
		if (Math.abs(series.maxY - maxY) < (maxY - minY)) {
			maxY = series.maxY;
		}
		if (Math.abs(series.minY - minY) < (maxY - minY)) {
			minY = series.minY;
		}
		
		// pad limits to give space around graph
		maxY = maxY + (maxY - minY) * 0.1;
		minY = minY - (maxY - minY) * 0.1;
		
		// if we wouldn't have any values to display between an axis and 0, clamp it to 0
		if (minY < 0 && series.yValuesInRange(minY, 0) == 0) {
			minY = 0;
		}
		if (maxY > 0 && series.yValuesInRange(0, maxY) == 0) {
			maxY = 0;
		}
		
		// handle completely flat graphs
		if (minY == maxY) {
			minY = minY - 5;
			maxY = maxY + 5;
		}

		this.minY = minY;
		this.maxY = maxY;
		
		// choose a plausibly-minimal number of fractional digits
		// for the y axis
		this.yScaleFormat = new DecimalFormat();
		int yFractionDigits = (int)Math.ceil(1/(maxY-minY));
		if (yFractionDigits > 4)
			yFractionDigits = 4;
		yScaleFormat.setMaximumFractionDigits(yFractionDigits);
		yScaleFormat.setMinimumFractionDigits(yFractionDigits);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		// we get the size of the area to paint 
		final double width = getWidth();
		final double height = getHeight();
		
		// we can't draw on a zero-size canvas
		// hopefully this is a transient condition
		if (width <= 0 || height <= 0)
			return;
		
		// find the y-axis position at which to draw the x-axis
		double xAxisY = scaleY(0, height);
		
		// clamp the x-axis to the borders
		if (xAxisY < borderWidth) {
			xAxisY = borderWidth;
		}
		if (xAxisY > height-borderWidth) {
			xAxisY = height-borderWidth;
		}
		
		// draw the y-axis.
		g2.draw(new Line2D.Double(borderWidth, borderWidth, borderWidth, height-borderWidth));
		
		// draw the x-axis.
		g2.draw(new Line2D.Double(borderWidth, xAxisY, width-borderWidth, xAxisY));
		
		// draw the equation
		g2.drawString("y="+equation.toString(), borderWidth , borderWidth-12);

		// draw the y axis
		final double yStep = (maxY - minY) / 20;
		for (double mark = minY; mark <= maxY; mark += yStep) {
			final double y = scaleY(mark, height);			
			if (y > height)
				continue;
			g2.draw(new Line2D.Double(borderWidth-2, y, borderWidth+2, y));
			g2.drawString(yScaleFormat.format(mark), 5, (int)y);
		}

		// draw the x axis
		final double xStep = (series.maxX - series.minX) / 10;
		for (double mark = series.minX; mark <= series.maxX; mark += xStep) {
			final double x = scaleX(mark, width);
			if (x > width)
				continue;
			g2.draw(new Line2D.Double(x, xAxisY+2, x, xAxisY-2));
			g2.drawString(""+mark, (int)(x+3), (int)(xAxisY+17));
		}
		
		g2.setPaint(Color.red);
		for (Point p : series) {
			final double x = scaleX(p.x, width);
			final double y = scaleY(p.y, height);
			if (y < borderWidth || y > height-borderWidth || Double.isNaN(y))
				continue;
			g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
		}
	}
	
	private double scaleX(double x, double width) {
		return x * ((width - 2*borderWidth) / (series.maxX - series.minX)) + borderWidth;
	}
	
	private double scaleY(double y, double h) {
		return h - (y - minY) * ((h - 2*borderWidth) / (maxY - minY)) - borderWidth;
	}
}
