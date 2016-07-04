package uk.co.mars;

/**
 * Location in a Grid.
 * 
 * @author Pradeep Thomas
 *
 */
public class GridLocation {

	/**
	 * X coordinate
	 */
	private volatile int x;

	/**
	 * Y coordinate
	 */
	private volatile int y;

	/**
	 * GridLocation.
	 * 
	 * @param x1
	 *            x coordinate
	 * @param y1
	 *            y coordinate
	 */
	public GridLocation(final int x1, final int y1) {
		this.x = x1;
		this.y = y1;
	}

	/**
	 * Increment X.
	 */
	public final void incrementX() {
		++x;
	}

	/**
	 * Decrement X.
	 */
	public final void decrementX() {
		--x;
	}

	/**
	 * Increment Y.
	 */
	public final void incrementY() {
		++y;
	}

	/**
	 * Decrement Y.
	 */
	public final void decrementY() {
		--y;
	}

	/**
	 * 
	 * @return X
	 */
	public final int getX() {
		return x;
	}

	/**
	 * Set X
	 * 
	 * @param x
	 */
	public final void setX(final int x) {
		this.x = x;
	}

	/**
	 * Get Y
	 * 
	 * @return Y
	 */
	public final int getY() {
		return y;
	}

	/**
	 * Set Y
	 * 
	 * @param y
	 *            Y
	 */
	public final void setY(final int y) {
		this.y = y;
	}

	@Override
	public final String toString() {
		return "GridLocation [x=" + x + ", y=" + y + "]";
	}

}
