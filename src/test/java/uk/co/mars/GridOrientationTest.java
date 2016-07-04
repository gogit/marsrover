package uk.co.mars;

import org.junit.Assert;
import org.junit.Test;

public class GridOrientationTest {

	@Test
	public void testGetCodeNorth() {
		Assert.assertEquals("N", GridOrientation.North.getCode());
	}

	@Test
	public void testGetCodeSouth() {
		Assert.assertEquals("S", GridOrientation.South.getCode());
	}

	@Test
	public void testGetCodeEast() {
		Assert.assertEquals("E", GridOrientation.East.getCode());
	}

	@Test
	public void testGetCodeWest() {
		Assert.assertEquals("W", GridOrientation.West.getCode());
	}

	@Test
	public void testLookupNorth() {
		Assert.assertEquals(GridOrientation.North, GridOrientation.getOrientation("N"));
	}

	@Test
	public void testLookupSouth() {
		Assert.assertEquals(GridOrientation.South, GridOrientation.getOrientation("S"));
	}

	@Test
	public void testLookupWest() {
		Assert.assertEquals(GridOrientation.West, GridOrientation.getOrientation("W"));
	}


	@Test
	public void testLookupEast() {
		Assert.assertEquals(GridOrientation.East, GridOrientation.getOrientation("E"));
	}

}
