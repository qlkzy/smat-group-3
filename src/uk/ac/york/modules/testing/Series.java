package uk.ac.york.modules.testing;

import java.util.ArrayList;
import java.util.Iterator;

public class Series implements Iterable<Point> {

	public final double minX;
	public final double maxX;
	
	public final double minY;
	public final double maxY;

	private final ArrayList<Point> points;
	
	public Series(Equation e, double minX, double maxX, double step) {
		assert step > 0;
		this.minX = minX;
		this.maxX = maxX;		
		this.points = new ArrayList<Point>();
		double minY = Double.POSITIVE_INFINITY;
		double maxY = Double.NEGATIVE_INFINITY;
		for (double x = minX; x < maxX; x += step) {
			double y = e.of(x);
			if (Double.isInfinite(y))
				y = Double.NaN;
			
			if (y < minY) minY = y;
			if (y > maxY) maxY = y;
			points.add(new Point(x, y));
		}
		this.minY = minY;
		this.maxY = maxY;
	}

	@Override
	public Iterator<Point> iterator() {
		return points.iterator();
	}

	public int size() {
		return points.size();
	}	
}
