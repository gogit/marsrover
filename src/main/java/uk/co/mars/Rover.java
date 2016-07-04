package uk.co.mars;

/**
 * Robotic Mars Rover.
 * 
 * @author Pradeep Thomas
 *
 */
public class Rover {

	/**
	 * The current location of the Rover.
	 */
	private GridLocation location;
	/**
	 * The current orientation of the Rover.
	 */
	private GridOrientation orientation;

	/**
	 * The max X coordinate of the plateau
	 */
	private final int maxX;

	/**
	 * The max Y coordinate of the plateau
	 */
	private final int maxY;

	/**
	 * 
	 */
	private final String name;

	/**
	 * 
	 * @param name1
	 * @param maxX
	 * @param maxY
	 */
	public Rover(final String name1, final int maxX, final int maxY) {
		this.name = name1;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	/**
	 * Rover.
	 * 
	 * @param name
	 *            name
	 * @param maxX
	 *            max X coordinate of the plateau
	 * @param maxY
	 *            max Y coordinate of the plateau
	 * @param location
	 *            of the Rover
	 * @param orientation
	 *            of the Rover.
	 */
	public Rover(final String name1, final int maxX, final int maxY, final GridLocation location,
			final GridOrientation orientation) {
		this(name1, maxX, maxY);
		this.location = location;
		this.orientation = orientation;
	}

	/**
	 * String of commands to the rover.
	 * 
	 * @param commands
	 *            to move the rover.
	 */
	public final void move(final String commands) {
		if (commands == null) {
			throw new IllegalArgumentException("Commands cannot be null");
		}
		String[] comms = commands.split("");
		for (String command : comms) {
			executeCommand(command);
		}
	}

	/**
	 * Execute a command to move M or turn left or right.
	 * 
	 * @param command
	 */
	public final void executeCommand(final String command) {
		switch (command) {
		case "M":
			// throws exception if its an invalid move
			canMove();
			move();
			break;
		case "L":
			turnLeft();
			break;
		case "R":
			turnRight();
			break;
		default:
			break;
		}
	}

	/**
	 * Turn left.
	 */
	public final void turnLeft() {
		GridOrientation or = null;
		switch (orientation) {
		case North:
			or = GridOrientation.West;
			break;
		case South:
			or = GridOrientation.East;
			break;
		case West:
			or = GridOrientation.South;
			break;
		case East:
			or = GridOrientation.North;
			break;
		default:
			throw new IllegalStateException();
		}
		orientation = or;
	}

	/**
	 * Turn right.
	 */
	public final void turnRight() {
		GridOrientation or = null;
		switch (orientation) {
		case North:
			or = GridOrientation.East;
			break;
		case South:
			or = GridOrientation.West;
			break;
		case West:
			or = GridOrientation.North;
			break;
		case East:
			or = GridOrientation.South;
			break;
		default:
			throw new IllegalStateException();
		}
		orientation = or;
	}

	/**
	 * Move forward.
	 */
	public void move() {
		switch (orientation) {
		case North:
			location.incrementY();
			break;
		case South:
			location.decrementY();
			break;
		case West:
			location.decrementX();
			break;
		case East:
			location.incrementX();
			break;
		}
	}

	/**
	 * Can the rover move forward, if it cannot the command was wrong and throw
	 * a runtime exception.
	 */
	public void canMove() {
		int x = location.getX();
		int y = location.getY();
		switch (orientation) {
		case North:
			++y;
			break;
		case South:
			--y;
			break;
		case West:
			--x;
			break;
		case East:
			++x;
			break;
		}
		if (x > maxX || x < 0) {
			throw new IllegalArgumentException(String.format("Cannot move to x=%s y=%s", x, y));
		}
		if (y > maxY || y < 0) {
			throw new IllegalArgumentException(String.format("Cannot move to x=%s y=%s", x, y));
		}
	}

	/**
	 * GridLocation.
	 * 
	 * @return GridLocation
	 */
	public final GridLocation getLocation() {
		return location;
	}

	/**
	 * Set Location.
	 * 
	 * @param location
	 */
	public final void setLocation(final GridLocation location) {
		this.location = location;
	}

	/**
	 * GridOrientation.
	 * 
	 * @return GridOrientation
	 */
	public final GridOrientation getOrientation() {
		return orientation;
	}

	/**
	 * GridOrientation.
	 * 
	 * @param orientation
	 *            GridOrientation
	 */
	public final void setOrientation(final GridOrientation orientation) {
		this.orientation = orientation;
	}

	/**
	 * Name.
	 * 
	 * @return name of the rover
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Output of the rover
	 * 
	 * @return
	 */
	public final String output() {
		return String.format("%s %s %s", location.getX(), location.getY(), orientation.getCode());
	}

	@Override
	public final String toString() {
		return String.format("Rover %s [%s %s %s]", name, location.getX(), location.getY(), orientation);
	}

}
