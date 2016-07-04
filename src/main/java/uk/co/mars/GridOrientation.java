package uk.co.mars;

/**
 * Orientation in a Grid.
 * 
 * @author Pradeep Thomas
 *
 */
public enum GridOrientation {
	/**
	 * Orientation
	 */
	North("N"), South("S"), East("E"), West("W");

	/**
	 * Code mapping to the Orientation
	 */
	private final String code;

	/**
	 * GridOrientation.
	 * 
	 * @param code1
	 */
	private GridOrientation(final String code1) {
		this.code = code1;
	}

	/**
	 * 
	 * @return the code
	 */
	public final String getCode() {
		return code;
	}

	/**
	 * Lookup the orientation
	 * 
	 * @param code
	 *            to map
	 * @return orientation
	 */
	public static final GridOrientation getOrientation(final String code) {
		switch (code) {
		case "N":
			return North;
		case "S":
			return South;
		case "E":
			return East;
		case "W":
			return West;
		default:
			throw new IllegalArgumentException(String.format("Direction Not Found %s ", code));
		}
	}

}
