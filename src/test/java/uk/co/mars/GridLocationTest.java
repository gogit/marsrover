package uk.co.mars;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class GridLocationTest {

	@Test
	public void testIncrementX() {
		GridLocation loc = new GridLocation(1, 1);
		loc.incrementX();
		Assert.assertEquals(2, loc.getX());
	}

	@Test
	public void testDecrementX() {
		GridLocation loc = new GridLocation(1, 1);
		loc.decrementX();
		Assert.assertEquals(0, loc.getX());
	}

	@Test
	public void testIncrementY() {
		GridLocation loc = new GridLocation(1, 1);
		loc.incrementY();
		Assert.assertEquals(2, loc.getY());
	}

	@Test
	public void testDecrementY() {
		GridLocation loc = new GridLocation(1, 1);
		loc.decrementY();
		Assert.assertEquals(0, loc.getY());
	}

}
