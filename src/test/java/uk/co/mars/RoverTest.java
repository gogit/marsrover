package uk.co.mars;

import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

	@Test
	public void testMoveUp() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.North);
		rover.move();
		Assert.assertEquals(3, rover.getLocation().getY());
		Assert.assertEquals(1, rover.getLocation().getX());
		Assert.assertEquals(GridOrientation.North, rover.getOrientation());
	}

	@Test
	public void testMoveDown() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.South);
		rover.move();
		Assert.assertEquals(1, rover.getLocation().getY());
		Assert.assertEquals(1, rover.getLocation().getX());
		Assert.assertEquals(GridOrientation.South, rover.getOrientation());
	}
	
	@Test
	public void testMoveLeft() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.West);
		rover.move();
		Assert.assertEquals(2, rover.getLocation().getY());
		Assert.assertEquals(0, rover.getLocation().getX());
		Assert.assertEquals(GridOrientation.West, rover.getOrientation());
	}
	
	@Test
	public void testMoveRight() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.East);
		rover.move();
		Assert.assertEquals(2, rover.getLocation().getY());
		Assert.assertEquals(2, rover.getLocation().getX());
		Assert.assertEquals(GridOrientation.East, rover.getOrientation());
	}

	@Test
	public void testExecuteCommandMove() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.North);
		rover.executeCommand("M");
		Assert.assertEquals(3, rover.getLocation().getY());
		Assert.assertEquals(1, rover.getLocation().getX());
		Assert.assertEquals(GridOrientation.North, rover.getOrientation());
		
	}

	@Test
	public void testTurnLeftFromNorth() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.North);
		rover.turnLeft();
		Assert.assertEquals(GridOrientation.West, rover.getOrientation());
	}

	@Test
	public void testTurnLeftFromSouth() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.South);
		rover.turnLeft();
		Assert.assertEquals(GridOrientation.East, rover.getOrientation());
	}
	@Test
	public void testTurnLeftFromEast() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.East);
		rover.turnLeft();
		Assert.assertEquals(GridOrientation.North, rover.getOrientation());
	}
	@Test
	public void testTurnLeftFromWest() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.West);
		rover.turnLeft();
		Assert.assertEquals(GridOrientation.South, rover.getOrientation());
	}

	@Test
	public void testTurnRightFromNorth() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.North);
		rover.turnRight();
		Assert.assertEquals(GridOrientation.East, rover.getOrientation());
	}

	@Test
	public void testTurnRightFromSouth() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.South);
		rover.turnRight();
		Assert.assertEquals(GridOrientation.West, rover.getOrientation());
	}
	@Test
	public void testTurnRightFromEast() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.East);
		rover.turnRight();
		Assert.assertEquals(GridOrientation.South, rover.getOrientation());
	}
	@Test
	public void testTurnRightFromWest() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(1, 2), GridOrientation.West);
		rover.turnRight();
		Assert.assertEquals(GridOrientation.North, rover.getOrientation());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCanMoveOutOfGridBottomLeft() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(0, 0), GridOrientation.South);
		rover.canMove();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCanMoveOutOfGridBottomRight() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(5, 0), GridOrientation.South);
		rover.canMove();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCanMoveOutOfGridTopRight() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(5, 5), GridOrientation.North);
		rover.canMove();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCanMoveOutOfGridTopLeft() {
		Rover rover = new Rover("rover1", 5, 5, new GridLocation(0, 5), GridOrientation.North);
		rover.canMove();
	}
}
