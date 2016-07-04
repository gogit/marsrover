package uk.co.mars;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MissionControlTest {

	/**
	 * Test Input: <br/>
	 * 5 5 1 <br/>
	 * 2 N <br/>
	 * LMLMLMLMM <br/>
	 * 3 3 E <br/>
	 * MMRMMRMRRM
	 * 
	 * Expected Output: 1 3 N 5 1 E
	 */
	@Test
	public void testExecuteCommands() {
		MissionControl mc = new MissionControl();
		// get the commands and execute them
		List<Rover> rovers = mc.executeCommands(commands());
		// test outputs
		Assert.assertEquals("1 3 N", rovers.get(0).output());
		Assert.assertEquals("5 1 E", rovers.get(1).output());
		
		Assert.assertEquals(1, rovers.get(0).getLocation().getX());
		Assert.assertEquals(3, rovers.get(0).getLocation().getY());
		Assert.assertEquals(GridOrientation.North, rovers.get(0).getOrientation());
		
		Assert.assertEquals(5, rovers.get(1).getLocation().getX());
		Assert.assertEquals(1, rovers.get(1).getLocation().getY());
		Assert.assertEquals(GridOrientation.East, rovers.get(1).getOrientation());
		
	}

	private List<String> commands() {
		return Arrays.asList(new String[] { "5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM" });
	}
}
