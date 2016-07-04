package uk.co.mars;

import java.util.Arrays;
import java.util.List;

/**
 * Wrapper for commands to the Rover.
 * 
 * @author Pradeep Thomas
 *
 */
public class MissionControl {

	/**
	 * 
	 * @param commands
	 */
	public final List<Rover> executeCommands(final List<String> commands) {
		if (commands == null || commands.size() < 5) {
			throw new IllegalArgumentException("Not enough commands to run the rovers");
		}
		int lineNo = 0;
		// line 1
		String gridTokens[] = commands.get(lineNo++).split("\\s");
		checkTokens(gridTokens, 2);
		Rover rover1 = createRover(lineNo, gridTokens[0], gridTokens[1]);
		// line2
		String tokens[] = commands.get(lineNo++).split("\\s");
		checkTokens(tokens, 3);
		setupRover(rover1, tokens[0], tokens[1], tokens[2]);
		// line 3
		rover1.move(commands.get(lineNo++));

		Rover rover2 = createRover(lineNo, gridTokens[0], gridTokens[1]);
		// line4
		tokens = commands.get(lineNo++).split("\\s");
		checkTokens(tokens, 3);
		setupRover(rover2, tokens[0], tokens[1], tokens[2]);
		// line 5
		rover2.move(commands.get(lineNo++));

		return Arrays.asList(new Rover[] { rover1, rover2 });
	}

	private final Rover createRover(final int no, final String mx, final String my) {
		Rover rover = new Rover(String.valueOf(no), Integer.parseInt(mx), Integer.parseInt(my));
		return rover;
	}

	private final void setupRover(final Rover rover, final String x, final String y, final String orientation) {
		rover.setLocation(new GridLocation(Integer.parseInt(x), Integer.parseInt(y)));
		rover.setOrientation(GridOrientation.getOrientation(orientation));
	}

	private final void checkTokens(final String tokens[], final int count) {
		if (tokens.length != count) {
			throw new IllegalArgumentException("Not enough information to run the rovers");
		}

	}

}
